package leetcode.heap

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TaskSchedulerTest {
    val solution = TaskScheduler()

    @Test
    fun leastInterval1() {
        val tasks = charArrayOf('A', 'A', 'A', 'B', 'B', 'B')
        val n = 2
        val result = solution.leastIntervalOptimized(tasks, n)

        assertEquals(8, result)
    }

    @Test
    fun leastInterval2() {
        val tasks = charArrayOf('A', 'A', 'A', 'B', 'B', 'B')
        val n = 0
        val result = solution.leastIntervalOptimized(tasks, n)

        assertEquals(6, result)
    }

    @Test
    fun leastInterval3() {
        val tasks = charArrayOf('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G')
        val n = 2
        val result = solution.leastIntervalOptimized(tasks, n)

        assertEquals(16, result)
    }
}