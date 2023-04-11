package backendQuestions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LoopToRecursionTest {
    val solution = LoopToRecursion()

    @Test
    fun maxValueIterative() {
        val arr = intArrayOf(1, 2, 3)
        val result = solution.maxValueIterative(arr)

        assertEquals(3, result)
    }

    @Test
    fun maxValueRecursive() {
        val arr = intArrayOf(1, 2, 3)
        val result = solution.maxValueRecursive(arr)

        assertEquals(3, result)
    }
}