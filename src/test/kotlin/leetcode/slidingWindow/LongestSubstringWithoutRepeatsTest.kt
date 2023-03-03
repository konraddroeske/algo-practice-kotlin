package leetcode.slidingWindow

import LongestSubstringWithoutRepeats
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LongestSubstringWithoutRepeatsTest {
    private val solution = LongestSubstringWithoutRepeats()

    @Test
    fun testLengthOfLongestSubstring1() {
        val input = "abcabcbb"
        val expected = 3
        assertEquals(expected, solution.lengthOfLongestSubstring(input))
    }

    @Test
    fun testLengthOfLongestSubstring2() {
        val input = "pwwkew"
        val expected = 3
        assertEquals(expected, solution.lengthOfLongestSubstring(input))
    }

    @Test
    fun testLengthOfLongestSubstring3() {
        val input = "qrsvbspk"
        val expected = 5
        assertEquals(expected, solution.lengthOfLongestSubstring(input))
    }
}
