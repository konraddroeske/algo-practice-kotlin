package leetcode.stack

import MinStack
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinStackTest {

    val solution = MinStack()

    @Test
    fun minStack1() {
        solution.push(-2)
        solution.push(0)
        solution.push(-3)

        val min1 = solution.getMin()
        assertEquals(-3, min1)

        solution.pop()

        val top = solution.top()
        assertEquals(0, top)

        val min2 = solution.getMin()
        assertEquals(-2, min2)
    }

    @Test
    fun minStack2() {
        solution.push(-2)
        solution.push(0)
        solution.push(-1)

        val min1 = solution.getMin()
        assertEquals(-2, min1)

        val top = solution.top()
        assertEquals(-1, top)

        solution.pop()

        val min2 = solution.getMin()
        assertEquals(-2, min2)
    }
}
