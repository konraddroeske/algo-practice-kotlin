package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WordBreakTest {
    val solution = WordBreak()

    @Test
    fun isWordBreak1() {
        val s = "leetcode"
        val wordDict = listOf("leet", "code")
        val result = solution.isWordBreak(s, wordDict)

        assertEquals(true, result)
    }

    @Test
    fun isWordBreak2() {
        val s = "applepenapple"
        val wordDict = listOf("apple", "pen")
        val result = solution.isWordBreak(s, wordDict)

        assertEquals(true, result)
    }

    @Test
    fun isWordBreak3() {
        val s = "catsandog"
        val wordDict = listOf("cats", "dog", "sand", "and", "cat")
        val result = solution.isWordBreak(s, wordDict)

        assertEquals(false, result)
    }
}