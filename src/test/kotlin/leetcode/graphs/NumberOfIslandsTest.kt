package leetcode.graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfIslandsTest {
    val solution = NumberOfIslands()

    @Test
    fun numIslands1() {
        val grid = arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0'),
        )
        val result = solution.numIslands(grid)
        assertEquals(1, result)
    }

    @Test
    fun numIslands2() {
        val grid = arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1'),
        )
        val result = solution.numIslands(grid)
        assertEquals(3, result)
    }
}