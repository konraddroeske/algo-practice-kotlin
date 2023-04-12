package leetcode.dp

import ClimbingStairs
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ClimbingStairsTest {
    val solution = ClimbingStairs()

    @Test
    fun climbStairs1() {
        val n = 2
        val result = solution.climbStairs(n)
        assertEquals(2, result)
    }

    @Test
    fun climbStairs2() {
        val n = 3
        val result = solution.climbStairs(n)
        assertEquals(3, result)
    }

    @Test
    fun climbStairs3() {
        val n = 4
        val result = solution.climbStairs(n)
        assertEquals(5, result)
    }
}