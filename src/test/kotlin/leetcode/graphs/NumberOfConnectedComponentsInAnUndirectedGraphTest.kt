package leetcode.graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumberOfConnectedComponentsInAnUndirectedGraphTest {
    val solution = NumberOfConnectedComponentsInAnUndirectedGraph()

    @Test
    fun countComponents1() {
        val n = 5
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(3, 4),
        )

        val result = solution.countComponents(n, edges)
        assertEquals(2, result)
    }

    @Test
    fun countComponents2() {
        val n = 5
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
        )

        val result = solution.countComponents(n, edges)
        assertEquals(1, result)
    }

    @Test
    fun countComponents3() {
        val n = 4
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(2, 3),
            intArrayOf(1, 2),
        )

        val result = solution.countComponents(n, edges)
        assertEquals(1, result)
    }
}