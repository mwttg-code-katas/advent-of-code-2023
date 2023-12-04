package com.aoc2023.day04

import com.aoc2023.utils.ReadFile
import kotlin.system.measureTimeMillis

fun main() {
    val allPoints: Int
    val time01 = measureTimeMillis { allPoints = puzzle1() }
    println("The points of all card decks combined is '$allPoints'. This took '$time01' ms.")

    val cardCopies: Int
    val time02 = measureTimeMillis { cardCopies = puzzle2() }
    println("There is a total of '$cardCopies' scratch cards. This took '$time02' ms.")
}

private fun puzzle1(): Int = ReadFile.asText("/files/input-day04.txt").sumOf { ScratchCard.createFrom(it).getPoints() }

private fun puzzle2(): Int {
    val cardLookUp = ReadFile.asText("/files/input-day04.txt").map { ScratchCard.createFrom(it) }.associateBy { it.id }
    var currentCardId = 1
    val result = mutableMapOf<Int, Int>()
    while (currentCardId <= cardLookUp.keys.size) {

        // add current card (original)
        if (result.containsKey(currentCardId)) {
            val newValue = result[currentCardId]!! + 1
            result[currentCardId] = newValue
        } else {
            result[currentCardId] = 1
        }

        // add copies
        for (cardRepeat in 1..result[currentCardId]!!) {
            val copies = cardLookUp[currentCardId]!!.copyCount()
            for (copyId in currentCardId + 1 .. currentCardId + copies) {
                if (copyId > cardLookUp.keys.size) break

                if (result.containsKey(copyId)) {
                    val newValue = result[copyId]!! + 1
                    result[copyId] = newValue
                } else {
                    result[copyId] = 1
                }
            }
        }

        currentCardId++
    }

    return result.values.sum()
}
