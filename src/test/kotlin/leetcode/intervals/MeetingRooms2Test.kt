package leetcode.intervals

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MeetingRooms2Test {
    val solution = MeetingRooms2()

    @Test
    fun minMeetingRooms1() {
        val intervals = arrayOf(
            intArrayOf(0, 30),
            intArrayOf(5, 10),
            intArrayOf(15, 20),
        )
        val result = solution.minMeetingRooms2Pointer(intervals)
        assertEquals(2, result)
    }

    @Test
    fun minMeetingRooms2() {
        val intervals = arrayOf(
            intArrayOf(7, 10),
            intArrayOf(2, 4),
        )
        val result = solution.minMeetingRooms2Pointer(intervals)
        assertEquals(1, result)
    }

    @Test
    fun minMeetingRooms3() {
        val intervals = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 4),
            intArrayOf(2, 5),
            intArrayOf(5, 6),
        )
        val result = solution.minMeetingRooms2Pointer(intervals)
        assertEquals(3, result)
    }
}