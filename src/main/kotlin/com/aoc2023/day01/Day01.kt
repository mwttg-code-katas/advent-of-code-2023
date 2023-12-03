package com.aoc2023.day01

import com.aoc2023.utils.ReadFile
import kotlin.system.measureTimeMillis

fun main() {
    val calibrationSum: Int
    val time01 = measureTimeMillis { calibrationSum = puzzle01() }
    println("The sum of the calibration values = '$calibrationSum'. This took '$time01' ms.")

    val calibrationSum2: Int
    val time02 = measureTimeMillis { calibrationSum2 = puzzle02() }
    println("The sum of the calibration values = '$calibrationSum2'. This took '$time02' ms.")
}

private fun puzzle01(): Int =
    ReadFile
        .asText("/files/input-day01.txt")
        .sumOf { line ->
            val (digits, _) = line.partition { it.isDigit() }
            digits.first().digitToInt() * 10 + digits.last().digitToInt()
        }

private val digitByWord = listOf(
    Pair("one", "1"),
    Pair("two", "2"),
    Pair("three", "3"),
    Pair("four", "4"),
    Pair("five", "5"),
    Pair("six", "6"),
    Pair("seven", "7"),
    Pair("eight", "8"),
    Pair("nine", "9"),
)

private fun puzzle02(): Int =
    ReadFile
        .asText("/files/input-day01.txt")
        .sumOf { line ->
            val replaced = replacement(line)
            val reversed = replacementReverse(line)
            val (digits, _) = replaced.partition { it.isDigit() }
            val (digitsReversed, _) = reversed.partition { it.isDigit() }
            val result = digits.first().digitToInt() * 10 + digitsReversed.last().digitToInt()
            result
        }

fun replacement(line: String): String {
    var result = ""

    for (char in line) {
        result += char
        for (replacement in digitByWord) {
            result = result.replace(replacement.first, replacement.second)
        }
    }

    return result
}


// ugly as hell, edge case was missing in example
// "oneight" should result in 18 NOT 11  : -> 1   : <- 8
fun replacementReverse(line: String): String {
    var result = ""

    for (char in line.reversed()) {
        result += char
        result = result.reversed()
        for (replacement in digitByWord) {
            result = result.replace(replacement.first, replacement.second)
        }
        result = result.reversed()
    }

    return result.reversed()
}
