package leetcode.stack

import ValidParentheses
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidParenthesesTest {
    val solution = ValidParentheses()

    @Test
    fun isValid1() {
        val input = "()"
        val result = solution.isValid(input)
        assertEquals(true, result)
    }

    @Test
    fun isValid2() {
        val input = "()[]{}"
        val result = solution.isValid(input)
        assertEquals(true, result)
    }

    @Test
    fun isValid3() {
        val input = "(]"
        val result = solution.isValid(input)
        assertEquals(false, result)
    }

    @Test
    fun isValid4() {
        val input = "]"
        val result = solution.isValid(input)
        assertEquals(false, result)
    }
}
