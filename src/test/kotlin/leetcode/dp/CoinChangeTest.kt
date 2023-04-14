package leetcode.dp

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CoinChangeTest {
    val solution = CoinChange()

    @Test
    fun getCoinChange1() {
        val coins = intArrayOf(1, 2, 5)
        val amount = 11
        val result = solution.getCoinChange(coins, amount)
        assertEquals(3, result)
    }

    @Test
    fun getCoinChange2() {
        val coins = intArrayOf(2)
        val amount = 3
        val result = solution.getCoinChange(coins, amount)
        assertEquals(-1, result)
    }

    @Test
    fun getCoinChange3() {
        val coins = intArrayOf(1)
        val amount = 0
        val result = solution.getCoinChange(coins, amount)
        assertEquals(0, result)
    }
}