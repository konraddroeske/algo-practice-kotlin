package leetcode.binarySearch

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MedianOfTwoSortedArraysTest {
    val solution = MedianOfTwoSortedArrays()

    @Test
    fun findMedian1() {
        val input1 = intArrayOf(1, 3)
        val input2 = intArrayOf(2)
        val result = solution.findMedian(input1, input2)

        assertEquals(2.0, result)
    }

    @Test
    fun findMedian2() {
        val input1 = intArrayOf(1, 2)
        val input2 = intArrayOf(3, 4)
        val result = solution.findMedian(input1, input2)

        assertEquals(2.5, result)
    }

    @Test
    fun findMedian3() {
        val input1 = intArrayOf(1, 2, 3, 4)
        val input2 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val result = solution.findMedian(input1, input2)

        assertEquals(3.0, result)
    }

    @Test
    fun findMedian4() {
        val input1 = intArrayOf(1, 2, 3, 4, 5)
        val input2 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
        val result = solution.findMedian(input1, input2)

        assertEquals(4.0, result)
    }
}
