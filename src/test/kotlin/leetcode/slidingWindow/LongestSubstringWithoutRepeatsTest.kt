package leetcode.slidingWindow

import org.junit.jupiter.api.Assertions.assertEquals
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

    @Test
    fun testLengthOfLongestSubstring4() {
        val input = ""
        val expected = 0
        assertEquals(expected, solution.lengthOfLongestSubstring(input))
    }

    @Test
    fun testLengthOfLongestSubstring5() {
        val input = " "
        val expected = 1
        assertEquals(expected, solution.lengthOfLongestSubstring(input))
    }

    @Test
    fun testLengthOfLongestSubstring6() {
        val input = "au"
        val expected = 2
        assertEquals(expected, solution.lengthOfLongestSubstring(input))
    }

    @Test
    fun testLengthOfLongestSubstring7() {
        val input = "dvdf"
        val expected = 3
        assertEquals(expected, solution.lengthOfLongestSubstring(input))
    }
}
