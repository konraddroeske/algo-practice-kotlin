package leetcode.backtracking

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CombinationSum2Test {
    val solution = CombinationSum2()

    @Test
    fun sum2Test1() {
        val candidates = intArrayOf(10, 1, 2, 7, 6, 1, 5)
        val target = 8
        val result = solution.sum2(candidates, target)

        println("result: $result")
    }

    @Test
    fun sum2Test2() {
        val candidates = intArrayOf(2, 5, 2, 1, 2)
        val target = 5
        val result = solution.sum2(candidates, target)

        println("result: $result")
    }
}