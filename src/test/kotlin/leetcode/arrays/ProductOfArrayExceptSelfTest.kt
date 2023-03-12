package leetcode.arrays

import ProductOfArrayExceptSelf
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class ProductOfArrayExceptSelfTest {
    val solution = ProductOfArrayExceptSelf()

    @Test
    fun productExceptSelf1() {
        val input = intArrayOf(1, 2, 3, 4)
        val result = solution.productExceptSelf(input)

        assertContentEquals(intArrayOf(24, 12, 8, 6), result)
    }

    @Test
    fun productExceptSelf2() {
        val input = intArrayOf(-1, 1, 0, -3, 3)
        val result = solution.productExceptSelf(input)

        assertContentEquals(intArrayOf(0, 0, 9, 0, 0), result)
    }
}
