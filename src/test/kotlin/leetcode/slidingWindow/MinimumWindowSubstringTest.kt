package leetcode.slidingWindow

import MinimumWindowSubstring
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumWindowSubstringTest {
    private val solution = MinimumWindowSubstring()

    @Test
    fun minWindow1() {
        val s = "ADOBECODEBANC"
        val t = "ABC"
        val result = solution.minWindow(s, t)
        assertEquals("BANC", result)
    }

    @Test
    fun minWindow2() {
        val s = "a"
        val t = "a"
        val result = solution.minWindow(s, t)
        assertEquals("a", result)
    }

    @Test
    fun minWindow3() {
        val s = "cabwefgewcwaefgcf"
        val t = "cae"
        val result = solution.minWindow(s, t)
        assertEquals("cwae", result)
    }

    @Test
    fun minWindow4() {
        val s = "cgklivwehljxrdzpfdqsapogwvjtvbzahjnsejwnuhmomlfsrvmrnczjzjevkdvroiluthhpqtffhlzyglrvorgnalk"
        val t = "mqfff"
        val result = solution.minWindow(s, t)
        assertEquals("fsrvmrnczjzjevkdvroiluthhpqtff", result)
    }
}
