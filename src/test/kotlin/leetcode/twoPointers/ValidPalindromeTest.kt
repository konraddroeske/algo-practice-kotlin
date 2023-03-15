package leetcode.twoPointers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidPalindromeTest {
    val solution = ValidPalindrome()

    @Test
    fun isPalindrome1() {
        val input = "A man, a plan, a canal: Panama"
        val result = solution.isPalindromeTwoPointer(input)
        assertEquals(true, result)
    }

    @Test
    fun isPalindrome2() {
        val input = "race a car"
        val result = solution.isPalindromeTwoPointer(input)
        assertEquals(false, result)
    }

    @Test
    fun isPalindrome3() {
        val input = " "
        val result = solution.isPalindromeTwoPointer(input)
        assertEquals(true, result)
    }
}
