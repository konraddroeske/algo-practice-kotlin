package leetcode.heap

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class KthLargestElementInAStreamTest {
    @Test
    fun add() {
        val k = 3
        val nums = intArrayOf(4, 5, 8, 2)
        val solution = KthLargest(k, nums)

        val result1 = solution.add(3)
        assertEquals(4, result1)

        val result2 = solution.add(5)
        assertEquals(5, result2)

        val result3 = solution.add(10)
        assertEquals(5, result3)

        val result4 = solution.add(9)
        assertEquals(8, result4)

        val result5 = solution.add(4)
        assertEquals(8, result5)
    }
}