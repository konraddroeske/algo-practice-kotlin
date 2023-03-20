package leetcode.binarySearch

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SearchInRotatedSortedArrayTest {
    val solution = SearchInRotatedSortedArray()

    @Test
    fun search1() {
        val input = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        val target = 0
        val result = solution.search(input, target)

        assertEquals(4, result)
    }

    @Test
    fun search2() {
        val input = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        val target = 3
        val result = solution.search(input, target)

        assertEquals(-1, result)
    }

    @Test
    fun search3() {
        val input = intArrayOf(1)
        val target = 0
        val result = solution.search(input, target)

        assertEquals(-1, result)
    }

    @Test
    fun search4() {
        val input = intArrayOf(1, 3)
        val target = 3
        val result = solution.search(input, target)

        assertEquals(1, result)
    }
}
