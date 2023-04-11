package leetcode.backtracking

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class PalindromePartitioningTest {
    val solution = PalindromePartitioning()

    @Test
    fun partition1() {
        val s = "aab"
        val result = solution.partition(s)

        assertContentEquals(listOf("a", "a", "b"), result[0])
        assertContentEquals(listOf("aa", "b"), result[1])
    }

    @Test
    fun partition2() {
        val s = "a"
        val result = solution.partition(s)

        assertContentEquals(listOf("a"), result[0])
    }

    @Test
    fun partition3() {
        val s = "efe"
        val result = solution.partition(s)

        println("result: $result")

        assertContentEquals(listOf("e", "f", "e"), result[0])
        assertContentEquals(listOf("efe"), result[1])
    }
}