package leetcode.slidingWindow

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockTest {
    val solution = BestTimeToBuyAndSellStock()

    @Test
    fun maxProfit1() {
        val input = intArrayOf(7, 1, 5, 3, 6, 4)
        val result = solution.maxProfitTwoPointers(input)

        assertEquals(5, result)
    }

    @Test
    fun maxProfit2() {
        val input = intArrayOf(7, 6, 4, 3, 1)
        val result = solution.maxProfitTwoPointers(input)

        assertEquals(0, result)
    }
}
