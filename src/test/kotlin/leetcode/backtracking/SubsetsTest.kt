package leetcode.backtracking

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubsetsTest {
    val solution = Subsets()

    @Test
    fun getSubsets1() {
        val nums = intArrayOf(1, 2, 3)
        val result = solution.getSubsets(nums)

        println("result: $result")
    }
}