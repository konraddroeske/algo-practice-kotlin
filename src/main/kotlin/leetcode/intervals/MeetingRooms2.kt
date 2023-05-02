package leetcode.intervals

import java.util.*

class MeetingRooms2 {
    fun minMeetingRoomsArr(intervals: Array<IntArray>): Int {
        var maxVal = 0

        intervals.forEach {
            maxVal = maxOf(maxVal, it[1])
        }

        val timeline = IntArray(maxVal + 1) { 0 }

        intervals.forEach {
            for (i in it[0]until it[1]) {
                timeline[i] += 1
            }
        }

        return timeline.max()
    }

    fun minMeetingRoomsHeap(intervals: Array<IntArray>): Int {
        Arrays.sort(intervals) { a, b -> a[0] - b[0] }

        val rooms = PriorityQueue<Int>()

        for ((start, end) in intervals) {
            if (rooms.isNotEmpty() && rooms.peek() <= start) {
                rooms.poll()
            }

            rooms.offer(end)
        }

        return rooms.size
    }

    fun minMeetingRooms2Pointer(intervals: Array<IntArray>): Int {
        val starts = IntArray(intervals.size)
        val ends = IntArray(intervals.size)

        intervals.forEachIndexed { i, interval ->
            starts[i] = interval[0]
            ends[i] = interval[1]
        }

        starts.sort()
        ends.sort()

        var count = 0
        var endIndex = 0

        for (startIndex in starts.indices) {
            val start = starts[startIndex]
            val end = ends[endIndex]

            if (start < end) {
                count += 1
            } else {
                endIndex += 1
            }
        }

        return count
    }
}