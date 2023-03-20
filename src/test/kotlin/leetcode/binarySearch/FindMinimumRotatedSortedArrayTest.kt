package leetcode.binarySearch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumRotatedSortedArrayTest {
    val solution = FindMinimumRotatedSortedArray()

    @Test
    fun findMin1() {
        val input = intArrayOf(3, 4, 5, 1, 2)
        val result = solution.findMin(input)

        assertEquals(1, result)
    }

    @Test
    fun findMin2() {
        val input = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        val result = solution.findMin(input)

        assertEquals(0, result)
    }

    @Test
    fun findMin3() {
        val input = intArrayOf(11, 13, 15, 17)
        val result = solution.findMin(input)

        assertEquals(11, result)
    }
}
