package leetcode.graphs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CourseScheduleTest {
    val solution = CourseSchedule()

    @Test
    fun canFinish1() {
        val numCourses = 2
        val prerequisites = arrayOf(
            intArrayOf(1, 0),
        )
        val result = solution.canFinishDFS(numCourses, prerequisites)
        assertEquals(true, result)
    }

    @Test
    fun canFinish2() {
        val numCourses = 2
        val prerequisites = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1),
        )
        val result = solution.canFinishDFS(numCourses, prerequisites)
        assertEquals(false, result)
    }

    @Test
    fun canFinish3() {
        val numCourses = 5
        val prerequisites = arrayOf(
            intArrayOf(1, 4),
            intArrayOf(2, 4),
            intArrayOf(3, 1),
            intArrayOf(3, 2),
        )
        val result = solution.canFinishDFS(numCourses, prerequisites)
        assertEquals(true, result)
    }
}