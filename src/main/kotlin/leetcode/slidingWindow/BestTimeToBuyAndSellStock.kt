package leetcode.slidingWindow

class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        var minVal = Int.MAX_VALUE
        var profit = 0

        for (price in prices) {
            minVal = minOf(minVal, price)
            profit = maxOf(profit, price - minVal)
        }

        return profit
    }

    fun maxProfitTwoPointers(prices: IntArray): Int {
        var left = 0
        var right = 1
        var result = 0

        while (right < prices.size) {
            if (prices[left] < prices[right]) {
                result = maxOf(result, prices[right] - prices[left])
            } else {
                left = right
            }

            right += 1
        }

        return result
    }
}
