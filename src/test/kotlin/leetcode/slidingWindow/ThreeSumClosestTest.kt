package leetcode.slidingWindow

import ThreeSumClosest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThreeSumClosestTest {
    private val solution = ThreeSumClosest()

    @Test
    fun threeSumClosest1() {
        val nums = intArrayOf(-1, 2, 1, -4)
        val target = 1
        val expected = 2

        assertEquals(expected, solution.threeSumClosest(nums, target))
    }

    @Test
    fun threeSumClosest2() {
        val nums = intArrayOf(0, 0, 0)
        val target = 1
        val expected = 0

        assertEquals(expected, solution.threeSumClosest(nums, target))
    }
}
