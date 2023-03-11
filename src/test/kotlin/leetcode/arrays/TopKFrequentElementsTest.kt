package leetcode.arrays

import TopKFrequentElements
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class TopKFrequentElementsTest {
    val solution = TopKFrequentElements()

    @Test
    fun topKFrequent1() {
        val input = intArrayOf(1, 1, 1, 2, 2, 3)
        val k = 2
        val result = solution.topKFrequentHeap(input, k)

        assertContentEquals(intArrayOf(1, 2), result)
    }

    @Test
    fun topKFrequent2() {
        val input = intArrayOf(1)
        val k = 1
        val result = solution.topKFrequentHeap(input, k)

        assertContentEquals(intArrayOf(1), result)
    }
}
