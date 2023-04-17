package leetcode.heap

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class KthLargestElementInAnArrayTest {
    val solution = KthLargestElementInAnArray()

    @Test
    fun findKthLargest1() {
        val nums = intArrayOf(3, 2, 1, 5, 6, 4)
        val k = 2
        val result = solution.findKthLargest(nums, k)

        assertEquals(5, result)
    }

    @Test
    fun findKthLargest2() {
        val nums = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
        val k = 4
        val result = solution.findKthLargest(nums, k)

        assertEquals(4, result)
    }
}