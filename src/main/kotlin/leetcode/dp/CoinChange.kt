package leetcode.dp

class CoinChange {
    fun getCoinChange(coins: IntArray, amount: Int): Int {
        val arr = IntArray(amount + 1) { Int.MAX_VALUE }
        arr[0] = 0

        for (index in 1..amount) {
            for (coin in coins) {
                if (index - coin >= 0) {
                    val prevCount = arr[index - coin]

                    if (prevCount != Int.MAX_VALUE) {
                        arr[index] = minOf(arr[index], prevCount + 1)
                    }
                }
            }
        }

        val final = arr[arr.size - 1]

        return if (final == Int.MAX_VALUE) -1 else final
    }
}
