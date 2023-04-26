package leetcode.intervals

import org.junit.jupiter.api.Test

class MergeIntervalsTest {
    val solution = MergeIntervals()

    @Test
    fun merge1() {
        val intervals = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 6),
            intArrayOf(8, 10),
            intArrayOf(15, 18),
        )
        val result = solution.merge(intervals)

        for (res in result) {
            println(res.contentToString())
        }
    }

    @Test
    fun merge2() {
        val intervals = arrayOf(
            intArrayOf(1, 4),
            intArrayOf(4, 5),
        )
        val result = solution.merge(intervals)

        for (res in result) {
            println(res.contentToString())
        }
    }

    @Test
    fun merge3() {
        val intervals = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 4),
            intArrayOf(5, 6),
        )
        val result = solution.merge(intervals)

        for (res in result) {
            println(res.contentToString())
        }
    }

    @Test
    fun merge4() {
        val intervals = arrayOf(
            intArrayOf(1, 4),
            intArrayOf(2, 3),
        )
        val result = solution.merge(intervals)

        for (res in result) {
            println(res.contentToString())
        }
    }
}