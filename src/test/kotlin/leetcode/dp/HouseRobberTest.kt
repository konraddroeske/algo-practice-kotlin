package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HouseRobberTest {
    val solution = HouseRobber()

    @Test
    fun rob1() {
        val nums = intArrayOf(1, 2, 3, 1)
        val result = solution.rob(nums)
        assertEquals(4, result)
    }

    @Test
    fun rob2() {
        val nums = intArrayOf(2, 7, 9, 3, 1)
        val result = solution.rob(nums)
        assertEquals(12, result)
    }
}