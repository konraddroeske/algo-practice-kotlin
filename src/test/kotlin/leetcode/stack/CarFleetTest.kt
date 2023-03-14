package leetcode.stack

import CarFleet
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarFleetTest {
    val solution = CarFleet()

    @Test
    fun carFleet1() {
        val target = 12
        val position = intArrayOf(10, 8, 0, 5, 3)
        val speed = intArrayOf(2, 4, 1, 1, 3)

        val result = solution.carFleet(target, position, speed)

        assertEquals(3, result)
    }

    @Test
    fun carFleet2() {
        val target = 10
        val position = intArrayOf(3)
        val speed = intArrayOf(3)

        val result = solution.carFleet(target, position, speed)

        assertEquals(1, result)
    }

    @Test
    fun carFleet3() {
        val target = 100
        val position = intArrayOf(0, 2, 4)
        val speed = intArrayOf(4, 2, 1)

        val result = solution.carFleet(target, position, speed)

        assertEquals(1, result)
    }

    @Test
    fun carFleet4() {
        val target = 10
        val position = intArrayOf(6, 8)
        val speed = intArrayOf(3, 2)

        val result = solution.carFleet(target, position, speed)

        assertEquals(2, result)
    }

    @Test
    fun carFleet5() {
        val target = 10
        val position = intArrayOf(0, 4, 2)
        val speed = intArrayOf(2, 1, 3)

        val result = solution.carFleet(target, position, speed)

        assertEquals(1, result)
    }
}
