package leetcode.slidingWindow

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LongestRepeatingCharacterReplacementTest {
    val solution = LongestRepeatingCharacterReplacement()

    @Test
    fun characterReplacement1() {
        val s = "ABAB"
        val k = 2
        val result = solution.characterReplacement(s, k)

        assertEquals(4, result)
    }

    @Test
    fun characterReplacement2() {
        val s = "AABABBA"
        val k = 1
        val result = solution.characterReplacement(s, k)

        assertEquals(4, result)
    }
}
