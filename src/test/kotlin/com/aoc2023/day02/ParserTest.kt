package com.aoc2023.day02

import org.junit.jupiter.api.Test

class ParserTest {

    @Test
    fun `test the parser`() {
        Parser.getGames("/files/day02.txt")
    }
}