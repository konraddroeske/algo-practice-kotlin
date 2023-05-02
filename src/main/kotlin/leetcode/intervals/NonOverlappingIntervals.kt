package leetcode.intervals

import java.util.*

class NonOverlappingIntervals {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        Arrays.sort(intervals) { a, b -> a[1] - b[1] }

        var result = intervals.size - 1
        var prev = intervals[0]

        for (index in 1 until intervals.size) {
            val cur = intervals[index]

            if (prev[1] > cur[0]) {
                continue
            }

            prev = cur
            result -= 1
        }

        return result
    }
}