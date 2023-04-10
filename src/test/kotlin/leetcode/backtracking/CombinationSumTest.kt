package leetcode.backtracking

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class CombinationSumTest {
    val solution = CombinationSum()

    @Test
    fun getSum1() {
        val candidates = intArrayOf(2, 3, 6, 7)
        val target = 7

        val result = solution.getSum(candidates, target)

        println("result 1: $result")

        assertContentEquals(result[0], listOf(2, 2, 3))
        assertContentEquals(result[1], listOf(7))
    }

    @Test
    fun getSum2() {
        val candidates = intArrayOf(2, 3, 5)
        val target = 8

        val result = solution.getSum(candidates, target)

        println("result 2: $result")

        assertContentEquals(result[0], listOf(2, 2, 2, 2))
        assertContentEquals(result[1], listOf(2, 3, 3))
        assertContentEquals(result[2], listOf(3, 5))
    }
}