package com.aoc2023.day02

import com.aoc2023.utils.ReadFile

object Parser {

    fun getGames(filename: String): List<Game> =
        ReadFile.asText(filename).map {
            val parts = it.split(": ")
            val id = parts[0].split(" ")[1].toInt()
            val sets = parts[1].split("; ")

            val cubeSet = mutableListOf<MutableList<CubeRecord>>()
            for (set in sets) {
                val cubes = set.split(", ")
                val cubeRecords = mutableListOf<CubeRecord>()

                for (cube in cubes) {
                    val (count, color) = cube.split(" ")
                    val record = CubeRecord(color, count.toInt())
                    cubeRecords.add(record)
                }
                cubeSet.add(cubeRecords)
            }
            Game(id, cubeSet)
        }
}