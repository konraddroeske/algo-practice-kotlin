package leetcode.dp

class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0

        val resultsArr = IntArray(amount + 1) { amount + 1 }
        resultsArr[0] = 0

        for (curAmount in 1..amount) {
            for (coin in coins) {
                if (coin <= curAmount) {
                    val prevIndex = (curAmount) - coin
                    val prevCoins = resultsArr[prevIndex]

                    resultsArr[curAmount] = minOf(
                        resultsArr[curAmount],
                        prevCoins + 1,
                    )
                }
            }
        }

        if (resultsArr[amount] == amount + 1) return -1

        return resultsArr[amount]
    }
}

fun main() {
    val coinChange = CoinChange()

    val coins1 = intArrayOf(1, 2, 5)
    val amount1 = 11
    val result1 = coinChange.coinChange(coins1, amount1)
    println("result1: $result1")

    val coins2 = intArrayOf(2)
    val amount2 = 3
    val result2 = coinChange.coinChange(coins2, amount2)
    println("result2: $result2")

    val coins3 = intArrayOf(1)
    val amount3 = 0
    val result3 = coinChange.coinChange(coins3, amount3)
    println("result3: $result3")

    val coins4 = intArrayOf(1)
    val amount4 = 2
    val result4 = coinChange.coinChange(coins4, amount4)
    println("result4: $result4")
}
