package leetcode.dp

class MaximumProductSubarray {
    fun maxProduct(nums: IntArray): Int {
        var curMax = nums[0]
        var curMin = nums[0]
        var result = curMax

        for (index in 1 until nums.size) {
            val num = nums[index]
            val tempMax = num * curMax

            curMax = maxOf(num, tempMax, num * curMin)
            curMin = minOf(num, tempMax, num * curMin)
            result = maxOf(result, curMax)
        }

        return result
    }
}
