package leetcode.backtracking

import org.junit.jupiter.api.Test

class LetterCombinationsOfAPhoneNumberTest {
    val solution = LetterCombinationsOfAPhoneNumber()

    @Test
    fun letterCombinations1() {
        val digits = "23"
        val result = solution.letterCombinations(digits)

        println("result: $result")
    }

    @Test
    fun letterCombinations2() {
        val digits = ""
        val result = solution.letterCombinations(digits)

        println("result: $result")
    }

    @Test
    fun letterCombinations3() {
        val digits = "2"
        val result = solution.letterCombinations(digits)

        println("result: $result")
    }
}