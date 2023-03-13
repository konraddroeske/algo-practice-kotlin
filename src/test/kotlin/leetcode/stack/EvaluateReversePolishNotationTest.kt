package leetcode.stack

import EvaluateReversePolishNotation
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EvaluateReversePolishNotationTest {

    val solution = EvaluateReversePolishNotation()

    @Test
    fun evalRPN1() {
        val input = arrayOf("2", "1", "+", "3", "*")
        val result = solution.evalRPN(input)
        assertEquals(9, result)
    }

    @Test
    fun evalRPN2() {
        val input = arrayOf("4", "13", "5", "/", "+")
        val result = solution.evalRPN(input)
        assertEquals(6, result)
    }

    @Test
    fun evalRPN3() {
        val input = arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")
        val result = solution.evalRPN(input)
        assertEquals(22, result)
    }
}
