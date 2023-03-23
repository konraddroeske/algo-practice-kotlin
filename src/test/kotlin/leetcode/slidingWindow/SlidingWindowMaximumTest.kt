package leetcode.slidingWindow

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class SlidingWindowMaximumTest {
    val solution = SlidingWindowMaximum()

    @Test
    fun maxSlidingWindow1() {
        val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
        val k = 3
        val result = solution.maxSlidingWindow(nums, k)
        val expected = intArrayOf(3, 3, 5, 5, 6, 7)
        assertContentEquals(expected, result)
    }

    @Test
    fun maxSlidingWindow2() {
        val nums = intArrayOf(1)
        val k = 1
        val result = solution.maxSlidingWindow(nums, k)
        val expected = intArrayOf(1)
        assertContentEquals(expected, result)
    }

    @Test
    fun maxSlidingWindow3() {
        val nums = intArrayOf(1, -1)
        val k = 1
        val result = solution.maxSlidingWindow(nums, k)
        val expected = intArrayOf(1, -1)
        assertContentEquals(expected, result)
    }

    @Test
    fun maxSlidingWindow4() {
        val nums = intArrayOf(7, 2, 4)
        val k = 2
        val result = solution.maxSlidingWindow(nums, k)
        val expected = intArrayOf(7, 4)
        assertContentEquals(expected, result)
    }

    @Test
    fun maxSlidingWindow5() {
        val nums = intArrayOf(2, 2, 2, 3, 3, 3, 1, 1)
        val k = 3
        val result = solution.maxSlidingWindow(nums, k)
        val expected = intArrayOf(2, 3, 3, 3, 3, 3)
        assertContentEquals(expected, result)
    }
}
