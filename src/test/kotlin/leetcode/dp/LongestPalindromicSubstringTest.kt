package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LongestPalindromicSubstringTest {
    val solution = LongestPalindromicSubstring()

    @Test
    fun longestPalindrome1() {
        val s = "babad"
        val result = solution.longestPalindrome(s)
        assertEquals("bab", result)
    }

    @Test
    fun longestPalindrome2() {
        val s = "cbbd"
        val result = solution.longestPalindrome(s)
        assertEquals("bb", result)
    }
}