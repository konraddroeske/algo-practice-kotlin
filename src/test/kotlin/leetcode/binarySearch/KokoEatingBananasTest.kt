package leetcode.binarySearch

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class KokoEatingBananasTest {
    val solution = KokoEatingBananas()

    @Test
    fun minEatingSpeed1() {
        val piles = intArrayOf(3, 6, 7, 11)
        val hours = 8

        val result = solution.minEatingSpeed(piles, hours)
        assertEquals(4, result)
    }

    @Test
    fun minEatingSpeed2() {
        val piles = intArrayOf(30, 11, 23, 4, 20)
        val hours = 5

        val result = solution.minEatingSpeed(piles, hours)
        assertEquals(30, result)
    }

    @Test
    fun minEatingSpeed3() {
        val piles = intArrayOf(30, 11, 23, 4, 20)
        val hours = 6

        val result = solution.minEatingSpeed(piles, hours)
        assertEquals(23, result)
    }

    @Test
    fun minEatingSpeed4() {
        val piles = intArrayOf(312884470)
        val hours = 312884469

        val result = solution.minEatingSpeed(piles, hours)
        assertEquals(2, result)
    }

    @Test
    fun minEatingSpeed5() {
        val piles = intArrayOf(980628391, 681530205, 734313996, 168632541)
        val hours = 819870953

        val result = solution.minEatingSpeed(piles, hours)
        assertEquals(4, result)
    }
}
