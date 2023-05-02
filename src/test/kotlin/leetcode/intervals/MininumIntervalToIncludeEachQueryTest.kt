package leetcode.intervals

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class MininumIntervalToIncludeEachQueryTest {
    val solution = MininumIntervalToIncludeEachQuery()

    @Test
    fun minInterval1() {
        val intervals = arrayOf(
            intArrayOf(1, 4),
            intArrayOf(2, 4),
            intArrayOf(3, 6),
            intArrayOf(4, 4),
        )
        val queries = intArrayOf(2, 3, 4, 5)
        val result = solution.minIntervalArr(intervals, queries)

        assertContentEquals(intArrayOf(3, 3, 1, 4), result)
    }

    @Test
    fun minInterval2() {
        val intervals = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(2, 5),
            intArrayOf(1, 8),
            intArrayOf(20, 25),
        )
        val queries = intArrayOf(2, 19, 5, 22)
        val result = solution.minIntervalArr(intervals, queries)

        assertContentEquals(intArrayOf(2, -1, 4, 6), result)
    }
}