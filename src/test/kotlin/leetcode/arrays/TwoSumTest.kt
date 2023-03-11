package leetcode.arrays

import TwoSum
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class TwoSumTest {
    val solution = TwoSum()

    @Test
    fun twoSum1() {
        val input = intArrayOf(2, 7, 11, 15)
        val target = 9
        val result = solution.twoSum(input, target)

        assertContentEquals(intArrayOf(0, 1), result)
    }

    @Test
    fun twoSum2() {
        val input = intArrayOf(3, 2, 4)
        val target = 6
        val result = solution.twoSum(input, target)

        assertContentEquals(intArrayOf(1, 2), result)
    }

    @Test
    fun twoSum3() {
        val input = intArrayOf(3, 3)
        val target = 6
        val result = solution.twoSum(input, target)

        assertContentEquals(intArrayOf(0, 1), result)
    }
}
