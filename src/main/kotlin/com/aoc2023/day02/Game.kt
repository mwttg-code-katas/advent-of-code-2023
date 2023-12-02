package com.aoc2023.day02

data class Game(val id: Int, val cubeSet: MutableList<MutableList<CubeRecord>> = mutableListOf())

data class CubeRecord(val color: String, val count: Int)
