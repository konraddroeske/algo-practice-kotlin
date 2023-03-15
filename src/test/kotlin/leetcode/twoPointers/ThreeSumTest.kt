package leetcode.twoPointers

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class ThreeSumTest {
    val solution = ThreeSum()

    @Test
    fun threeSum() {
        val input = intArrayOf(-1, 0, 1, 2, -1, -4)
        val expected = arrayOf(
            listOf(-1, -1, 2),
            listOf(-1, 0, 1),
        )
        val result = solution.threeSum(input)

        for ((index, res) in result.withIndex()) {
            assertContentEquals(expected[index], res)
        }
    }
}
