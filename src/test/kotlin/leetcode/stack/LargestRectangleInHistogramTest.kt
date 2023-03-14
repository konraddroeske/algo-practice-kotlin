package leetcode.stack

import LargestRectangleInHistogram
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LargestRectangleInHistogramTest {
    val solution = LargestRectangleInHistogram()

    @Test
    fun largestRectangleArea1() {
        val input = intArrayOf(2, 1, 5, 6, 2, 3)
        val result = solution.largestRectangleArea(input)
        assertEquals(10, result)
    }

    @Test
    fun largestRectangleArea2() {
        val input = intArrayOf(2, 4)
        val result = solution.largestRectangleArea(input)
        assertEquals(4, result)
    }

    @Test
    fun largestRectangleArea3() {
        val input = intArrayOf(1, 2, 3, 4, 5)
        val result = solution.largestRectangleArea(input)
        assertEquals(9, result)
    }

    @Test
    fun largestRectangleArea4() {
        val input = intArrayOf(2, 1, 2)
        val result = solution.largestRectangleArea(input)
        assertEquals(3, result)
    }
}
