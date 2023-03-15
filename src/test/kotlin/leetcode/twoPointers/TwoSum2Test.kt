package leetcode.twoPointers

import TwoSum2
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class TwoSum2Test {
    val solution = TwoSum2()

    @Test
    fun twoSum1() {
        val input = intArrayOf(2, 7, 11, 15)
        val target = 9
        val result = solution.twoSumTwoPointer(input, target)
        val expected = intArrayOf(1, 2)
        assertContentEquals(expected, result)
    }

    @Test
    fun twoSum2() {
        val input = intArrayOf(2, 3, 4)
        val target = 6
        val result = solution.twoSumTwoPointer(input, target)
        val expected = intArrayOf(1, 3)
        assertContentEquals(expected, result)
    }

    @Test
    fun twoSum3() {
        val input = intArrayOf(-1, 0)
        val target = -1
        val result = solution.twoSumTwoPointer(input, target)
        val expected = intArrayOf(1, 2)
        assertContentEquals(expected, result)
    }
}
