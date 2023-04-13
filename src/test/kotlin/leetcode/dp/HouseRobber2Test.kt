package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HouseRobber2Test {
    val solution = HouseRobber2()

    @Test
    fun rob1() {
        val nums = intArrayOf(2, 3, 2)
        val result = solution.rob(nums)
        assertEquals(3, result)
    }

    @Test
    fun rob2() {
        val nums = intArrayOf(1, 2, 3, 1)
        val result = solution.rob(nums)
        assertEquals(4, result)
    }

    @Test
    fun rob3() {
        val nums = intArrayOf(1, 2, 3)
        val result = solution.rob(nums)
        assertEquals(3, result)
    }

    @Test
    fun rob4() {
        val nums = intArrayOf(0)
        val result = solution.rob(nums)
        assertEquals(0, result)
    }
}