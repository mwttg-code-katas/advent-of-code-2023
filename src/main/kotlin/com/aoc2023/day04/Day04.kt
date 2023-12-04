package com.aoc2023.day04

import com.aoc2023.utils.ReadFile
import kotlin.system.measureTimeMillis

fun main() {
    val allPoints: Int
    val time01 = measureTimeMillis { allPoints = puzzle1() }
    println("The points of all card decks combined is '$allPoints'. This took '$time01' ms.")
}

private fun puzzle1(): Int = ReadFile.asText("/files/input-day04.txt").sumOf { ScratchCard.createFrom(it).getPoints() }