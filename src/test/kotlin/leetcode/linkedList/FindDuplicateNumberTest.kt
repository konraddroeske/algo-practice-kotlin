package leetcode.linkedList

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class FindDuplicateNumberTest {
    val solution = FindDuplicateNumber()

    @Test
    fun findDuplicate1() {
        val nums = intArrayOf(1, 3, 4, 2, 2)
        val result = solution.findDuplicate(nums)

        assertEquals(2, result)
    }

    @Test
    fun findDuplicate2() {
        val nums = intArrayOf(3, 1, 3, 4, 2)
        val result = solution.findDuplicate(nums)

        assertEquals(3, result)
    }
}