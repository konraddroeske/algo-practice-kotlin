package leetcode.backtracking

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WordSearchTest {
    val solution = WordSearch()

    @Test
    fun exist1() {
        val board = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E'),
        )
        val word = "ABCCED"
        val result = solution.exist(board, word)

        assertEquals(true, result)
    }

    @Test
    fun exist2() {
        val board = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E'),
        )
        val word = "SEE"
        val result = solution.exist(board, word)

        assertEquals(true, result)
    }

    @Test
    fun exist3() {
        val board = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E'),
        )
        val word = "ABCB"
        val result = solution.exist(board, word)

        assertEquals(false, result)
    }

    @Test
    fun exist4() {
        val board = arrayOf(
            charArrayOf('a'),
        )
        val word = "a"
        val result = solution.exist(board, word)

        assertEquals(true, result)
    }
}