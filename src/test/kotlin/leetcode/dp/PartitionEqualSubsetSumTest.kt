package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PartitionEqualSubsetSumTest {
    val solution = PartitionEqualSubsetSum()

    @Test
    fun canPartition1() {
        val nums = intArrayOf(1, 5, 11, 5)
        val result = solution.canPartition(nums)
        assertEquals(true, result)
    }

    @Test
    fun canPartition2() {
        val nums = intArrayOf(1, 2, 3, 5)
        val result = solution.canPartition(nums)
        assertEquals(false, result)
    }

    @Test
    fun canPartition3() {
        val nums = intArrayOf(1, 2, 5, 2)
        val result = solution.canPartition(nums)
        assertEquals(true, result)
    }

    @Test
    fun canPartition4() {
        val nums = intArrayOf(3, 3, 3, 4, 5)
        val result = solution.canPartition(nums)
        assertEquals(true, result)
    }
}