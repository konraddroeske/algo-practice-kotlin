package leetcode.intervals

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MeetingRoomsTest {
    val solution = MeetingRooms()

    @Test
    fun canAttendMeetings1() {
        val intervals = arrayOf(
            intArrayOf(0, 30),
            intArrayOf(5, 10),
            intArrayOf(15, 20),
        )
        val result = solution.canAttendMeetings(intervals)
        assertEquals(false, result)
    }

    @Test
    fun canAttendMeetings2() {
        val intervals = arrayOf(
            intArrayOf(7, 10),
            intArrayOf(2, 4),
        )
        val result = solution.canAttendMeetings(intervals)
        assertEquals(true, result)
    }
}