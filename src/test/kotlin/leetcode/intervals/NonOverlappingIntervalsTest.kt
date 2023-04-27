package leetcode.intervals

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NonOverlappingIntervalsTest {
    val solution = NonOverlappingIntervals()

    @Test
    fun eraseOverlapIntervals1() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(1, 3),
        )
        val result = solution.eraseOverlapIntervals(intervals)

        assertEquals(1, result)
    }

    @Test
    fun eraseOverlapIntervals2() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 2),
            intArrayOf(1, 2),
        )
        val result = solution.eraseOverlapIntervals(intervals)

        assertEquals(2, result)
    }

    @Test
    fun eraseOverlapIntervals3() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
        )
        val result = solution.eraseOverlapIntervals(intervals)

        assertEquals(0, result)
    }
}