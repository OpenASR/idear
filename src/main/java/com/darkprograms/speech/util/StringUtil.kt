package com.darkprograms.speech.util

/**
 * A string utility class for commonly used methods.
 * These methods are particularly useful for parsing.
 * @author Skylion
 */
object StringUtil {
    /**
     * Removes quotation marks from beginning and end of string.
     * @param s The string you want to remove the quotation marks from.
     * @return The modified String.
     */
    fun stripQuotes(s: String): String {
        var start = 0
        if (s.startsWith("\"")) {
            start = 1
        }
        var end = s.length
        if (s.endsWith("\"")) {
            end = s.length - 1
        }
        return s.substring(start, end)
    }

    /**
     * Returns the first instance of String found exclusively between part1 and part2.
     * @param s The String you want to substring.
     * @param part1 The beginning of the String you want to search for.
     * @param part2 The end of the String you want to search for.
     * @return The String between part1 and part2.
     * If the s does not contain part1 or part2, the method returns null.
     */
    fun substringBetween(s: String, part1: String, part2: String): String? {
        var sub: String? = null

        val i = s.indexOf(part1)
        val j = s.indexOf(part2, i + part1.length)

        if (i != -1 && j != -1) {
            val nStart = i + part1.length
            sub = s.substring(nStart, j)
        }

        return sub
    }

    /**
     * Gets the string exclusively between the first instance of part1 and the last instance of part2.
     * @param s The string you want to trim.
     * @param part1 The term to trim after first instance.
     * @param part2 The term to before last instance of.
     * @return The trimmed String
     */
    fun trimString(s: String, part1: String, part2: String): String? {
        if (part1 !in s || part2 !in s) return null
        val first = s.indexOf(part1) + part1.length + 1
        var tmp = s.substring(first)
        val last = tmp.lastIndexOf(part2)
        tmp = tmp.substring(0, last)
        return tmp
    }

}
