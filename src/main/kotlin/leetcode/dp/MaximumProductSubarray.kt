package leetcode.dp

class MaximumProductSubarray {
    fun maxProduct(nums: IntArray): Int {
        var result = Int.MIN_VALUE
        var curMax = 1
        var curMin = 1

        for (num in nums) {
            if (num == 0) {
                curMax = 1
                curMin = 1
                result = maxOf(result, num)
            } else {
                val tempMax = num * curMax

                curMax = maxOf(num, tempMax, num * curMin)
                curMin = minOf(num, tempMax, num * curMin)
                result = maxOf(result, curMax)
            }
        }

        return result
    }
}
