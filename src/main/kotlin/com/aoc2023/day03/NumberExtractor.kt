package com.aoc2023.day03

object NumberExtractor {

    fun from(line: List<Char>, position: Int): Int? {
        if (!line[position].isDigit()) {
            return null
        }

        var result = ""
        for (index in position - 1 downTo 0) {
            if (line[index].isDigit()) {
                result += line[index]
            } else {
                break
            }
        }
        result = result.reversed()
        result += line[position]
        for (index in position + 1..<line.size) {
            if (line[index].isDigit()) {
                result += line[index]
            } else {
                break
            }
        }

        return result.toInt()
    }
}