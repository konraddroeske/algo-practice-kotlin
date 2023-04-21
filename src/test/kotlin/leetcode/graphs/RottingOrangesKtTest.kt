package leetcode.graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RottingOrangesKtTest {
    val solution = RottingOranges()

    @Test
    fun orangesRotting1() {
        val grid1 = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 1, 1),
        )

        val result = solution.orangesRotting(grid1)
        assertEquals(4, result)
    }

    @Test
    fun orangesRotting2() {
        val grid1 = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(1, 0, 1),
        )

        val result = solution.orangesRotting(grid1)
        assertEquals(-1, result)
    }

    @Test
    fun orangesRotting3() {
        val grid2 = arrayOf(
            intArrayOf(0, 2),
        )

        val result = solution.orangesRotting(grid2)
        assertEquals(0, result)
    }

    @Test
    fun orangesRotting4() {
        val grid2 = arrayOf(
            intArrayOf(1),
        )

        val result = solution.orangesRotting(grid2)
        assertEquals(-1, result)
    }

    @Test
    fun orangesRotting5() {
        val grid2 = arrayOf(
            intArrayOf(1, 2),
        )

        val result = solution.orangesRotting(grid2)
        assertEquals(1, result)
    }
}