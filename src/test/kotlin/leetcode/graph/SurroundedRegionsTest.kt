package leetcode.graph

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SurroundedRegionsTest {
    val solution = SurroundedRegions()

    @Test
    fun solve() {
        val board = arrayOf(
            charArrayOf('O', 'X', 'X', 'X'),
            charArrayOf('X', 'O', 'O', 'X'),
            charArrayOf('X', 'X', 'O', 'X'),
            charArrayOf('X', 'O', 'X', 'X'),
        )
        solution.solve(board)

        for (row in board) {
            println(row.contentToString())
        }
    }
}