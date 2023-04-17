package leetcode.heap

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LastStoneWeightTest {
    val solution = LastStoneWeight()

    @Test
    fun getLastStoneWeight1() {
        val stones = intArrayOf(2, 7, 4, 1, 8, 1)
        val result = solution.getLastStoneWeight(stones)
        assertEquals(1, result)
    }

    @Test
    fun getLastStoneWeight2() {
        val stones = intArrayOf(1)
        val result = solution.getLastStoneWeight(stones)
        assertEquals(1, result)
    }
}