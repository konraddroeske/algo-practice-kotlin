package leetcode.binarySearch

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BinarySearchTest {
    val solution = BinarySearch()

    @Test
    fun search1() {
        val input = intArrayOf(-1, 0, 3, 5, 9, 12)
        val target = 9

        val result = solution.search(input, target)

        assertEquals(4, result)
    }

    @Test
    fun search2() {
        val input = intArrayOf(-1, 0, 3, 5, 9, 12)
        val target = 2

        val result = solution.search(input, target)

        assertEquals(-1, result)
    }

    @Test
    fun search3() {
        val input = intArrayOf(5)
        val target = 5

        val result = solution.search(input, target)

        assertEquals(0, result)
    }

    @Test
    fun search4() {
        val input = intArrayOf(2, 5)
        val target = 5

        val result = solution.search(input, target)

        assertEquals(1, result)
    }
}
