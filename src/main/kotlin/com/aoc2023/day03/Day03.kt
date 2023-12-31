package com.aoc2023.day03

import kotlin.system.measureTimeMillis

fun main() {
    val partNumberSum: Int
    val time01 = measureTimeMillis { partNumberSum = puzzle1() }
    println("The sum of all part numbers is '$partNumberSum'. This took '$time01' ms.")

    val gearRationSum: Int
    val time02 = measureTimeMillis { gearRationSum = puzzle2() }
    println("The sum of all gear ratios is '$gearRationSum'. This took '$time02' ms.")
}

private fun puzzle1(): Int {
    val engine = Engine.create("/files/input-day03.txt")
    return engine.getSumOfPartNumbers()
}

private fun puzzle2(): Int {
    val engine = Engine.create("/files/input-day03.txt")
    return engine.getSumOfGearRatios()
}