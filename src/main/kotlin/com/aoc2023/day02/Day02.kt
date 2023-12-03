package com.aoc2023.day02

import kotlin.system.measureTimeMillis

fun main() {
    val possibleGamesSum: Int
    val time01 = measureTimeMillis { possibleGamesSum = puzzle01() }
    println("The sum of the valid game ids is '$possibleGamesSum'. This took '$time01' ms.")

    val sumOfPower: Int
    val time02 = measureTimeMillis { sumOfPower = puzzle02() }
    println("The sum of power is '$sumOfPower'. This took '$time02' ms.")
}

private val possibles = mapOf(
    Pair("red", 12),
    Pair("green", 13),
    Pair("blue", 14)
)

private fun puzzle01(): Int {
    val games = Parser.getGames("/files/input-day02.txt")
    val gameIds = mutableListOf<Int>()
    loop@ for (game in games) {
        for (cubeSet in game.cubeSet) {
            for (record in cubeSet) {
                if (record.count > possibles[record.color]!!) {
                    continue@loop
                }
            }
        }
        gameIds.add(game.id)
    }
    return gameIds.sum()
}

private fun puzzle02(): Int {
    val games = Parser.getGames("/files/input-day02.txt")
    var result = 0
    for (game in games) {
        val maxCubes = mutableMapOf<String, Int>()
        for (cubeSet in game.cubeSet) {
            for (record in cubeSet) {
                if (!maxCubes.containsKey(record.color)) {
                    maxCubes[record.color] = record.count
                }
                if (maxCubes[record.color]!! < record.count) {
                    maxCubes[record.color] = record.count
                }
            }
        }

        val product = maxCubes.values.reduce{acc, i -> acc * i}
        result += product
    }
    return result
}