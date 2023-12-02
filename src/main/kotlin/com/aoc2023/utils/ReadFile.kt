package com.aoc2023.utils

object ReadFile {

    fun asText(filename: String): List<String> =
        object {}.javaClass.getResourceAsStream(filename).bufferedReader().readLines()
}