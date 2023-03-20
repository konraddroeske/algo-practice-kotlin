package leetcode.twoPointers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TrappingRainWaterTest {
    val solution = TrappingRainWater()

    @Test
    fun trap1() {
        val input = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
        val result = solution.trapTwoPointer(input)
        assertEquals(6, result)
    }

    @Test
    fun trap2() {
        val input = intArrayOf(4, 2, 0, 3, 2, 5)
        val result = solution.trapTwoPointer(input)
        assertEquals(9, result)
    }

    @Test
    fun trap3() {
        val input = intArrayOf(5, 4, 1, 2)
        val result = solution.trapTwoPointer(input)
        assertEquals(1, result)
    }

    @Test
    fun trap4() {
        val input = intArrayOf(9, 6, 8, 8, 5, 6, 3)
        val result = solution.trapTwoPointer(input)
        assertEquals(3, result)
    }
}
