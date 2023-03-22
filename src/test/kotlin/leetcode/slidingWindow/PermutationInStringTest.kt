package leetcode.slidingWindow

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PermutationInStringTest {
    val solution = PermutationInString()

    @Test
    fun checkInclusion1() {
        val s1 = "ab"
        val s2 = "eidbaooo"

        val result = solution.checkInclusion(s1, s2)
        assertEquals(true, result)
    }

    @Test
    fun checkInclusion2() {
        val s1 = "ab"
        val s2 = "eidboaoo"

        val result = solution.checkInclusion(s1, s2)
        assertEquals(false, result)
    }
}
