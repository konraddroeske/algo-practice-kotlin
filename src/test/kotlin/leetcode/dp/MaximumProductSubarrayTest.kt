package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumProductSubarrayTest {
    val solution = MaximumProductSubarray()

    @Test
    fun maxProduct1() {
        val nums = intArrayOf(2, 3, -2, 4)
        val result = solution.maxProduct(nums)
        assertEquals(6, result)
    }

    @Test
    fun maxProduct2() {
        val nums = intArrayOf(-2, 0, -1)
        val result = solution.maxProduct(nums)
        assertEquals(0, result)
    }

    @Test
    fun maxProduct3() {
        val nums = intArrayOf(-2, 0, -1, -5, -3, -2)
        val result = solution.maxProduct(nums)
        assertEquals(30, result)
    }

    @Test
    fun maxProduct4() {
        val nums = intArrayOf(0)
        val result = solution.maxProduct(nums)
        assertEquals(0, result)
    }
}