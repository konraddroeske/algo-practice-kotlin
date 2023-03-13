package leetcode.stack

import GenerateParentheses
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class GenerateParenthesesTest {
    val solution = GenerateParentheses()

    @Test
    fun generateParentheses1() {
        val input = 3
        val result = solution.generateParentheses(input)
        val expected = listOf("((()))", "(()())", "(())()", "()(())", "()()()")

        assertContentEquals(expected, result)
    }

    @Test
    fun generateParentheses2() {
        val input = 1
        val result = solution.generateParentheses(input)
        val expected = listOf("()")

        assertContentEquals(expected, result)
    }
}
