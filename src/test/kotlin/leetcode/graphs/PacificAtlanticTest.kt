package leetcode.graphs

import org.junit.jupiter.api.Test

class PacificAtlanticTest {

    val solution = PacificAtlantic()

    @Test
    fun getPacificAtlantic() {
        val heights = arrayOf(
            intArrayOf(1, 2, 2, 3, 5),
            intArrayOf(3, 2, 3, 4, 4),
            intArrayOf(2, 4, 5, 3, 1),
            intArrayOf(6, 7, 1, 4, 5),
            intArrayOf(5, 1, 1, 2, 4),
        )

        val result = solution.getPacificAtlantic(heights)

        println(result)
    }
}