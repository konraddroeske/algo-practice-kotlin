package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DecodeWaysTest {
    val solution = DecodeWays()

    @Test
    fun numDecodings1() {
        val s = "12"
        val result = solution.numDecodings(s)
        assertEquals(2, result)
    }

    @Test
    fun numDecodings2() {
        val s = "226"
        val result = solution.numDecodings(s)
        assertEquals(3, result)
    }

    @Test
    fun numDecodings3() {
        val s = "06"
        val result = solution.numDecodings(s)
        assertEquals(0, result)
    }
}