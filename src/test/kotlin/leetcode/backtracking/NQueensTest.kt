package leetcode.backtracking

import org.junit.jupiter.api.Test

class NQueensTest {
    val solution = NQueens()

    @Test
    fun solveNQueens1() {
        val n = 4
        val result = solution.solveNQueens(n)

        println("result: $result")
    }

    @Test
    fun solveNQueens2() {
        val n = 1
        val result = solution.solveNQueens(n)

        println("result: $result")
    }

    @Test
    fun solveNQueens3() {
        val n = 5
        val result = solution.solveNQueens(n)

        println("result: $result")
    }
}