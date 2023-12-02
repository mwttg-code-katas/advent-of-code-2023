package com.aoc2023.day01

import com.aoc2023.utils.ReadFile
import kotlin.system.measureTimeMillis

fun main() {
    val calibrationSum: Int
    val time01 = measureTimeMillis { calibrationSum = puzzle01() }
    println("The sum of the calibration values = '$calibrationSum'. This took '$time01' ms.")
}

private fun puzzle01(): Int =
    ReadFile
        .asText("/files/input-day01.txt")
        .sumOf { line ->
            val (digits, _) = line.partition { it.isDigit() }
            digits.first().digitToInt() * 10 + digits.last().digitToInt()
        }

