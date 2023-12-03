package com.aoc2023.utils

object ReadFile {

    fun asText(filename: String): List<String> =
        object {}.javaClass.getResourceAsStream(filename).bufferedReader().readLines()

    fun asChar(filename: String): List<List<Char>> = object {}.javaClass.getResourceAsStream(filename)
        .bufferedReader()
        .readLines()
        .map { line -> line.map { char -> char } }
}