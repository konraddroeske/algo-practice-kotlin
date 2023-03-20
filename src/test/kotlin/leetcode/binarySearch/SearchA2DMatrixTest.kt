package leetcode.binarySearch

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SearchA2DMatrixTest {
    val solution = SearchA2DMatrix()

    @Test
    fun searchMatrix1() {
        val input = arrayOf(
            intArrayOf(1, 3, 5, 7),
            intArrayOf(10, 11, 16, 20),
            intArrayOf(23, 30, 34, 60),
        )
        val target = 3

        val result = solution.searchMatrix(input, target)
        assertEquals(true, result)
    }

    @Test
    fun searchMatrix2() {
        val input = arrayOf(
            intArrayOf(1, 3, 5, 7),
            intArrayOf(10, 11, 16, 20),
            intArrayOf(23, 30, 34, 60),
        )
        val target = 60

        val result = solution.searchMatrix(input, target)
        assertEquals(true, result)
    }
}
