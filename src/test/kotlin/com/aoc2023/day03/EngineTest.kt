package com.aoc2023.day03

import com.aoc2023.utils.ReadFile
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactly
import strikt.assertions.isEqualTo
import strikt.assertions.isNull

class EngineTest {

    @Test
    fun `read engine schematic`() {
        val grid = ReadFile.asChar("/files/day03.txt")
        println(grid)
    }

    @Test
    fun `extract the number`() {
        //  index           0    1    2    3    4    5    6    7    8    9
        val input = listOf('.', '.', '1', '2', '3', '4', '5', '6', '.', '.')
        expectThat(NumberExtractor.from(input, 2)).isEqualTo(123456)
        expectThat(NumberExtractor.from(input, 3)).isEqualTo(123456)
        expectThat(NumberExtractor.from(input, 7)).isEqualTo(123456)
        expectThat(NumberExtractor.from(input, 1)).isNull()
        expectThat(NumberExtractor.from(input, 8)).isNull()
    }

    @Test
    fun `check adjacent numbers`() {
        val engine = Engine.create("/files/day03.txt")
        expectThat(engine.getAdjacentNumbersOf(3, 1)).containsExactly(467, 35)
        expectThat(engine.getAdjacentNumbersOf(6, 3)).containsExactly(633)
        expectThat(engine.getAdjacentNumbersOf(3, 4)).containsExactly(617)
        expectThat(engine.getAdjacentNumbersOf(5, 5)).containsExactly(592)
        expectThat(engine.getAdjacentNumbersOf(3, 8)).containsExactly(664)
        expectThat(engine.getAdjacentNumbersOf(5, 8)).containsExactly(755, 598)
    }
}