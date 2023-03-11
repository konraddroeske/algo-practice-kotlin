package leetcode.arrays

import ContainsDuplicate
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ContainsDuplicateTest {
    val solution = ContainsDuplicate()

    @Test
    fun containsDuplicate1() {
        val input = intArrayOf(1, 2, 3, 1)
        val result = solution.containsDuplicate(input)

        assertEquals(true, result)
    }

    @Test
    fun containsDuplicate2() {
        val input = intArrayOf(1, 2, 3, 4)
        val result = solution.containsDuplicate(input)

        assertEquals(false, result)
    }

    @Test
    fun containsDuplicate3() {
        val input = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)
        val result = solution.containsDuplicate(input)

        assertEquals(true, result)
    }
}
