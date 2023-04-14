package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PalindromicSubstringsTest {
    val solution = PalindromicSubstrings()

    @Test
    fun countSubstrings1() {
        val s = "abc"
        val result = solution.countSubstrings(s)
        assertEquals(3, result)
    }

    @Test
    fun countSubstrings2() {
        val s = "aaa"
        val result = solution.countSubstrings(s)
        assertEquals(6, result)
    }
}