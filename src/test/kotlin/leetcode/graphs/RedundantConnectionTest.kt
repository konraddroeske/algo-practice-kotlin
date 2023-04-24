package leetcode.graphs

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class RedundantConnectionTest {
    val solution = RedundantConnection()

    @Test
    fun findRedundantConnection1() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 3),
        )
        val result = solution.findRedundantConnectionUF(edges)
        assertContentEquals(intArrayOf(2, 3), result)
    }

    @Test
    fun findRedundantConnection2() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(1, 4),
            intArrayOf(1, 5),
        )
        val result = solution.findRedundantConnectionUF(edges)
        assertContentEquals(intArrayOf(1, 4), result)
    }

    @Test
    fun findRedundantConnection3() {
        val edges = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(3, 4),
            intArrayOf(1, 5),
            intArrayOf(3, 5),
            intArrayOf(2, 3),
        )
        val result = solution.findRedundantConnectionUF(edges)
        assertContentEquals(intArrayOf(3, 5), result)
    }
}