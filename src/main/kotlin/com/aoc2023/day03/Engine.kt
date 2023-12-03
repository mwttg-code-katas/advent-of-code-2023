package com.aoc2023.day03

import com.aoc2023.utils.ReadFile

class Engine private constructor(private val grid: List<List<Char>>) {

    fun getSumOfGearRatios(): Int {
        var sum = 0
        for (y in grid.indices) {
            for (x in grid[y].indices) {
                if (grid[y][x] == '*') {
                    val numbers = getAdjacentNumbersOf(x, y)
                    if (numbers.size == 2) {
                        val product = numbers[0] * numbers[1]
                        sum += product
                    }
                }
            }
        }

        return sum
    }

    fun getSumOfPartNumbers(): Int {
        var sum = 0
        for (y in grid.indices) {
            for (x in grid[y].indices) {
                if (!grid[y][x].isDigit() && grid[y][x] != '.') {
                    val numbers = getAdjacentNumbersOf(x, y)
                    sum += numbers.sum()
                }
            }
        }

        return sum
    }

    fun getAdjacentNumbersOf(x: Int, y: Int): List<Int> {
        val result = mutableListOf<Int?>()
        for (deltaY in -1..1) {
            if ((y + deltaY) < 0 || (y + deltaY) > grid.size) continue
            for (deltaX in -1..1) {
                if ((x + deltaX) < 0 || (x + deltaX) > grid[y].size) continue

                val number = NumberExtractor.from(grid[y + deltaY], x + deltaX)
                if (!result.contains(number)) {
                    result.add(number)
                }
            }
        }

        return result.filterNotNull()
    }

    companion object {

        fun create(filename: String): Engine = Engine(ReadFile.asChar(filename))
    }
}
