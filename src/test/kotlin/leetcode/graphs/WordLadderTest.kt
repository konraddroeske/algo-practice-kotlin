package leetcode.graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WordLadderTest {
    val solution = WordLadder()

    @Test
    fun ladderLength1() {
        val beginWord = "hit"
        val endWord = "cog"
        val wordList = listOf("hot", "dot", "dog", "lot", "log", "cog")

        val result = solution.ladderLength(beginWord, endWord, wordList)

        assertEquals(5, result)
    }

    @Test
    fun ladderLength2() {
        val beginWord = "hit"
        val endWord = "cog"
        val wordList = listOf("hot", "dot", "dog", "lot", "log")

        val result = solution.ladderLength(beginWord, endWord, wordList)

        assertEquals(0, result)
    }

    @Test
    fun ladderLength3() {
        val beginWord = "talk"
        val endWord = "tail"
        val wordList = listOf(
            "talk",
            "tons",
            "fall",
            "tail",
            "gale",
            "hall",
            "negs",
        )

        val result = solution.ladderLength(beginWord, endWord, wordList)

        assertEquals(0, result)
    }
}