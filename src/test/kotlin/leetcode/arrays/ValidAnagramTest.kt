package leetcode.arrays

import ValidAnagram
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidAnagramTest {
    val solution = ValidAnagram()

    @Test
    fun isAnagram1() {
        val s = "anagram"
        val t = "nagaram"
        val result = solution.isAnagram(s, t)

        assertEquals(true, result)
    }

    @Test
    fun isAnagram2() {
        val s = "rat"
        val t = "car"
        val result = solution.isAnagram(s, t)

        assertEquals(false, result)
    }
}
