package leetcode.graphs

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class CourseSchedule2Test {
    val solution = CourseSchedule2()

    @Test
    fun findOrder1() {
        val numCourses = 1
        val prerequisites = arrayOf<IntArray>()

        val result = solution.findOrderDFS(numCourses, prerequisites)

        assertContentEquals(intArrayOf(0), result)
    }

    @Test
    fun findOrder2() {
        val numCourses = 3
        val prerequisites = arrayOf(
            intArrayOf(1, 0),
        )

        val result = solution.findOrderDFS(numCourses, prerequisites)

        assertContentEquals(intArrayOf(0, 2, 1), result)
    }
}