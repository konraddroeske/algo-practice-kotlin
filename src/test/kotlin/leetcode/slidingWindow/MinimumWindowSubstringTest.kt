package leetcode.slidingWindow

import MinimumWindowSubstring
import org.junit.jupiter.api.Test

class MinimumWindowSubstringTest {
    private val solution = MinimumWindowSubstring()

    @Test
    fun minWindow1() {
        val s1 = "ADOBECODEBANC"
        val t1 = "ABC"
        val result1 = solution.minWindow(s1, t1)
        println("result1: $result1")
    }

    @Test
    fun minWindow2() {
        val s2 = "bba"
        val t2 = "ab"
        val result2 = solution.minWindow(s2, t2)
        println("result2: $result2")
    }

    @Test
    fun minWindow3() {
        val s3 = "cabwefgewcwaefgcf"
        val t3 = "cae"
        val result3 = solution.minWindow(s3, t3)
        println("result3: $result3")
    }
}
