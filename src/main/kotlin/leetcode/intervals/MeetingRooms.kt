package leetcode.intervals

import java.util.*

// Time - O(n log n)
class MeetingRooms {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        Arrays.sort(intervals) { a, b -> a[0] - b[0] }

        var prev = intervals[0]

        for (i in 1 until intervals.size) {
            val cur = intervals[i]

            if (cur[0] < prev[1]) {
                return false
            }

            prev = cur
        }

        return true
    }
}