package leetcode.heap

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class KClosestPointsToOriginTest {
    val solution = KClosestPointsToOrigin()

    @Test
    fun kClosest1() {
        val points = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(-2, 2),
        )
        val k = 1
        val result = solution.kClosest(points, k)

        assertContentEquals(result[0], intArrayOf(-2, 2))
    }

    @Test
    fun kClosest2() {
        val points = arrayOf(
            intArrayOf(3, 3),
            intArrayOf(5, -1),
            intArrayOf(-2, 4),
        )
        val k = 2
        val result = solution.kClosest(points, k)

        assertContentEquals(result[1], intArrayOf(-2, 4))
        assertContentEquals(result[0], intArrayOf(3, 3))
    }
}