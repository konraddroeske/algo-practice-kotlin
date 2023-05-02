package leetcode.intervals

import java.util.*

// Time - O(n log n + q log q)
class MininumIntervalToIncludeEachQuery {
    fun minIntervalArr(intervals: Array<IntArray>, queries: IntArray): IntArray {
        Arrays.sort(intervals) { a, b -> a[0] - b[0] }
        val results = HashMap<Int, Int>().withDefault { -1 }
        var i = 0

        val minHeap = PriorityQueue<IntArray> { a, b ->
            when {
                a[0] == b[0] -> a[1] - b[1]
                else -> a[0] - b[0]
            }
        }

        for (query in queries.sorted()) {
            while (i < intervals.size && intervals[i][0] <= query) {
                val (start, end) = intervals[i]
                val score = end - start + 1

                minHeap.add(intArrayOf(score, end))
                i += 1
            }

            while (minHeap.isNotEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll()
            }

            if (minHeap.isNotEmpty()) {
                results[query] = minHeap.peek()[0]
            }
        }

        for (j in queries.indices) {
            queries[j] = results.getValue(queries[j])
        }

        return queries
    }
}