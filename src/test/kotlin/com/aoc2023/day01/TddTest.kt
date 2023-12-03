package com.aoc2023.day01

import com.aoc2023.utils.ReadFile
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isTrue

class TddTest {

    @Test
    fun `check for words`() {
        val input = "qwonedr"
        val actual = input.contains("one")
        expectThat(actual).isTrue()

        val newInput = input.replace("one", "1")
        expectThat(newInput).isEqualTo("qw1dr")
    }

    @Test
    fun `test treb7uchet`() {
        val (digits, _) = "treb7uchet".partition { it.isDigit() }
        val result = digits.first().digitToInt() * 10 + digits.last().digitToInt()
        expectThat(result).isEqualTo(77)
    }

    @Test
    fun `test part 2 stuff`() {
        val input = ReadFile.asText("/files/day01-part2.txt")
        val result = input
            .map { replacement(it) }
            .let {
                println(it)
                it
            }
            .sumOf { line ->
            val (digits, _) = line.partition { it.isDigit() }
            println(digits)
            digits.first().digitToInt() * 10 + digits.last().digitToInt()
        }
        println(input)
        println(result)
    }
}