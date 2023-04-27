package leetcode.intervals

class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()

        for ((i, interval) in intervals.withIndex()) {
            if (newInterval[1] < interval[0]) {
                result.add(newInterval)

                for (j in i until intervals.size) {
                    result.add(intervals[j])
                }

                return result.toTypedArray()
            } else if (newInterval[0] > interval[1]) {
                result.add(interval)
            } else {
                newInterval[0] = minOf(newInterval[0], interval[0])
                newInterval[1] = maxOf(newInterval[1], interval[1])
            }
        }

        result.add(newInterval)

        return result.toTypedArray()
    }
}