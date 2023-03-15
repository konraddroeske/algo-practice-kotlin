package leetcode.twoPointers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ContainerWithMostWaterTest {
    val solution = ContainerWithMostWater()

    @Test
    fun maxArea1() {
        val input = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        val result = solution.maxArea(input)
        val expected = 49
        assertEquals(expected, result)
    }

    @Test
    fun maxArea2() {
        val input = intArrayOf(1, 1)
        val result = solution.maxArea(input)
        val expected = 1
        assertEquals(expected, result)
    }

    @Test
    fun maxArea3() {
        val input = intArrayOf(1, 3, 2, 5, 25, 24, 5)
        val result = solution.maxArea(input)
        val expected = 24
        assertEquals(expected, result)
    }
}
