package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinCostClimbingStairsTest {
    val solution = MinCostClimbingStairs()

    @Test
    fun minCostClimbingStairs1() {
        val cost = intArrayOf(10, 15, 20)
        val result = solution.minCost(cost)
        assertEquals(15, result)
    }

    @Test
    fun minCostClimbingStairs2() {
        val cost = intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)
        val result = solution.minCost(cost)
        assertEquals(6, result)
    }
}