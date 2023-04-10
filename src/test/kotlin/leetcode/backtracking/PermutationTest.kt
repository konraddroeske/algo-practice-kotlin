package leetcode.backtracking

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class PermutationTest {
    val solution = Permutation()

    @Test
    fun permute1() {
        val nums = intArrayOf(1, 2, 3)
        val result = solution.permute(nums)

        println("result1: $result")

        assertContentEquals(listOf(1, 2, 3), result[0])
        assertContentEquals(listOf(1, 3, 2), result[1])
        assertContentEquals(listOf(2, 1, 3), result[2])
        assertContentEquals(listOf(2, 3, 1), result[3])
        assertContentEquals(listOf(3, 1, 2), result[4])
        assertContentEquals(listOf(3, 2, 1), result[5])
    }

    @Test
    fun permute2() {
        val nums = intArrayOf(0, 1)
        val result = solution.permute(nums)

        assertContentEquals(listOf(1, 0), result[1])
        assertContentEquals(listOf(0, 1), result[0])
    }

    @Test
    fun permute3() {
        val nums = intArrayOf(1)
        val result = solution.permute(nums)

        assertContentEquals(listOf(1), result[0])
    }
}