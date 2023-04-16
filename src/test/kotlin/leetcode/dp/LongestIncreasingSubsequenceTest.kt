package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LongestIncreasingSubsequenceTest {
    val solution = LongestIncreasingSubsequence()

    @Test
    fun lengthOfLIS1() {
        val nums = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
        val result = solution.lengthOfLIS(nums)
        assertEquals(4, result)
    }

    @Test
    fun lengthOfLIS2() {
        val nums = intArrayOf(0, 1, 0, 3, 2, 3)
        val result = solution.lengthOfLIS(nums)
        assertEquals(4, result)
    }

    @Test
    fun lengthOfLIS3() {
        val nums = intArrayOf(7, 7, 7, 7, 7, 7, 7)
        val result = solution.lengthOfLIS(nums)
        assertEquals(1, result)
    }
}