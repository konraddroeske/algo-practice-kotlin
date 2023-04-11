package leetcode.backtracking

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Subsets2Test {
    val solution = Subsets2()

    @Test
    fun subsetsWithDup1() {
        val nums = intArrayOf(1, 2, 2)
        val result = solution.subsetsWithDup(nums)

        println("result: $result")
    }

    @Test
    fun subsetsWithDup2() {
        val nums = intArrayOf(0)
        val result = solution.subsetsWithDup(nums)

        println("result: $result")
    }

    @Test
    fun subsetsWithDup3() {
        val nums = intArrayOf(4, 4, 4, 1, 4)
        val result = solution.subsetsWithDup(nums)

        println("result: $result")
    }

    @Test
    fun subsetsWithDup4() {
        val nums = intArrayOf(-1, 1, 2)
        val result = solution.subsetsWithDup(nums)

        println("result: $result")
    }
}