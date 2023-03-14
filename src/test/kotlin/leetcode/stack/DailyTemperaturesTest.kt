package leetcode.stack

import DailyTemperatures
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class DailyTemperaturesTest {
    val solution = DailyTemperatures()

    @Test
    fun dailyTemperatures1() {
        val input = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
        val result = solution.dailyTemperatures(input)
        val expected = intArrayOf(1, 1, 4, 2, 1, 1, 0, 0)

        assertContentEquals(expected, result)
    }

    @Test
    fun dailyTemperatures2() {
        val input = intArrayOf(30, 40, 50, 60)
        val result = solution.dailyTemperatures(input)
        val expected = intArrayOf(1, 1, 1, 0)

        assertContentEquals(expected, result)
    }

    @Test
    fun dailyTemperatures3() {
        val input = intArrayOf(30, 60, 90)
        val result = solution.dailyTemperatures(input)
        val expected = intArrayOf(1, 1, 0)

        assertContentEquals(expected, result)
    }

    @Test
    fun dailyTemperatures4() {
        val input = intArrayOf(30, 20, 15, 25, 30, 35)
        val result = solution.dailyTemperatures(input)
        val expected = intArrayOf(5, 2, 1, 1, 1, 0)

        assertContentEquals(expected, result)
    }

    @Test
    fun dailyTemperatures5() {
        val input = intArrayOf(30, 99, 99, 99, 100)
        val result = solution.dailyTemperatures(input)
        val expected = intArrayOf(1, 3, 2, 1, 0)

        assertContentEquals(expected, result)
    }
}
