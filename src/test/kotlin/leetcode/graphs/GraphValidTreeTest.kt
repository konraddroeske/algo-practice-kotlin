package leetcode.graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GraphValidTreeTest {
    val solution = GraphValidTree()

    @Test
    fun validTree1() {
        val n = 5
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3),
            intArrayOf(1, 4),
        )

        val result = solution.validTree(n, edges)
        assertEquals(true, result)
    }

    @Test
    fun validTree2() {
        val n = 5
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(1, 3),
            intArrayOf(1, 4),
        )

        val result = solution.validTree(n, edges)
        assertEquals(false, result)
    }

    @Test
    fun validTree3() {
        val n = 4
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(2, 3),
        )

        val result = solution.validTree(n, edges)
        assertEquals(false, result)
    }
}