package leetcode.arrays

import LongestConsecutiveSequence
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LongestConsecutiveSequenceTest {
    val solution = LongestConsecutiveSequence()

    @Test
    fun longestConsecutive1() {
        val input = intArrayOf(100, 4, 200, 1, 3, 2)
        val result = solution.longestConsecutive(input)

        assertEquals(4, result)
    }

    @Test
    fun longestConsecutive2() {
        val input = intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)
        val result = solution.longestConsecutive(input)

        assertEquals(9, result)
    }

    @Test
    fun longestConsecutive3() {
        val input = intArrayOf(0)
        val result = solution.longestConsecutive(input)

        assertEquals(1, result)
    }

    @Test
    fun longestConsecutive4() {
        val input = intArrayOf(0, 1)
        val result = solution.longestConsecutive(input)

        assertEquals(2, result)
    }

    @Test
    fun longestConsecutive5() {
        val input = intArrayOf(0, 0, 1)
        val result = solution.longestConsecutive(input)

        assertEquals(2, result)
    }

    @Test
    fun longestConsecutive6() {
        val input = intArrayOf(1, 2, 0, 1)
        val result = solution.longestConsecutive(input)

        assertEquals(3, result)
    }
}
