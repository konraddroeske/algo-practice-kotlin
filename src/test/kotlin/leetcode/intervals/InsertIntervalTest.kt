package leetcode.intervals

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InsertIntervalTest {
    val solution = InsertInterval()

    @Test
    fun insert1() {
        val intervals = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(6, 9),
        )

        val newInterval = intArrayOf(2, 5)

        val result = solution.insert(intervals, newInterval)

        for (res in result) {
            println(res.contentToString())
        }
    }

    @Test
    fun insert2() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 5),
            intArrayOf(6, 7),
            intArrayOf(8, 10),
            intArrayOf(12, 16),
        )

        val newInterval = intArrayOf(4, 8)

        val result = solution.insert(intervals, newInterval)

        for (res in result) {
            println(res.contentToString())
        }
    }
}