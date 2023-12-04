package com.aoc2023.day04

import com.aoc2023.utils.ReadFile
import org.junit.jupiter.api.Test

class RegExExtractionTest {

    @Test
    fun `check extraction with RegEx`() {
        val line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
        val regEx2 = Regex("(Card (\\d+)):(\\s+(\\d+)){5} |(\\s+(\\d+)){8}")
        val regEx3 = Regex("""Card (<?id>\d+):\s+(<?w1>\d+)\s+(<?w2>\d+)\s+(<?w3>\d+)\s+(<?w4>\d+)\s+(<?w5>\d+) |\s+(<?n1>\d+)\s+(<?n2>\d+)\s+(<?n3>\d+)\s+(<?n4>\d+)\s+(<?n5>\d+)\s+(<?n6>\d+)\s+(<?n7>\d+)\s+(<?n8>\d+)""")
        val regEx = Regex("""Card (?<id>\d+): +(?<w1>\d+) +(?<w2>\d+) +(?<w3>\d+) +(?<w4>\d+) +(?<w5>\d+) \| +(?<n1>\d+) +(?<n2>\d+) +(?<n3>\d+) +(?<n4>\d+) +(?<n5>\d+) +(?<n6>\d+) +(?<n7>\d+) +(?<n8>\d+)""")
        //val regEx = Regex("""[Card ](?<id>\d+)[:](.*)""")

        val matches = regEx.matchEntire(line)
        val destructured = matches!!.destructured
        for (x in destructured.toList()) {
            println(x)
        }


//        val matches = regEx.matchEntire(line)?.groups
//        val findings = regEx.findAll(line)
//        println(matches)
//        println("findings")
//        findings.forEach {
//            val destructured = it.destructured
//            val groupValues = it.groupValues
//            print("destructured: ${destructured.toList()} - groupValues: $groupValues - values: ")
//            it.groups.forEach { g ->
//                val value = g?.value
//                print("'$value' ")
//            }
//            println()
//        }
//        println("splits")
//        val isMatching = regEx.matches(line)
//        val splits = regEx.splitToSequence(line)
//        splits.forEach {
//            print("'$it' ")
//        }

        println("xx")
    }
}