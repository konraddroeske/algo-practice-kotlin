package leetcode.intervals

import java.util.*

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        Arrays.sort(intervals) { a, b -> a[0] - b[0] }

        val result = mutableListOf(intervals[0])

        for (index in 1 until intervals.size) {
            val prevEnd = result[result.size - 1][1]
            val curStart = intervals[index][0]
            val curEnd = intervals[index][1]

            if (prevEnd >= curStart) {
                result[result.size - 1][1] = maxOf(prevEnd, curEnd)
            } else {
                result.add(intervals[index])
            }
        }

        return result.toTypedArray()
    }
    fun mergeHeap(intervals: Array<IntArray>): Array<IntArray> {
        val minHeap = PriorityQueue<Pair<Int, Int>> { a, b ->
            when {
                a.first != b.first -> a.first - b.first
                else -> b.second - a.second
            }
        }

        for (interval in intervals) {
            minHeap.add(Pair(interval[0], 1))
            minHeap.add(Pair(interval[1], -1))
        }

        val result = mutableListOf<IntArray>()
        var curVal = 0
        var start = 0

        while (minHeap.isNotEmpty()) {
            val (index, interval) = minHeap.poll()

            if (interval > 0) {
                if (curVal == 0) {
                    start = index
                }

                curVal += interval
            }

            if (interval < 0) {
                curVal += interval

                if (curVal == 0) {
                    result.add(intArrayOf(start, index))
                }
            }
        }

        return result.toTypedArray()
    }
}