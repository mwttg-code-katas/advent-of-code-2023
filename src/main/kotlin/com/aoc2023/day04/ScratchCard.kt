package com.aoc2023.day04

import kotlin.math.pow

data class ScratchCard(val id: Int, val winningNumbers: Set<Int>, val numbers: Set<Int>) {

    fun getPoints(): Int {
        val intersection = numbers.intersect(winningNumbers)
        return if (intersection.isEmpty()) {
            0
        } else {
            2.0.pow(intersection.size - 1).toInt()
        }
    }

    fun copyCount(): Int = numbers.intersect(winningNumbers).size

    companion object {

        private val regex =
            Regex("""Card +(\d+): +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) \| +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+) +(\d+)""")

        fun createFrom(line: String): ScratchCard {
            val matches = regex.matchEntire(line)
            val destructured = matches!!.destructured.toList()
            return ScratchCard(
                id = destructured[0].toInt(),
                winningNumbers = destructured.subList(1, 11).map { it.toInt() }.toSet(),
                numbers = destructured.subList(11, destructured.size).map { it.toInt() }.toSet()
            )
        }
    }
}
