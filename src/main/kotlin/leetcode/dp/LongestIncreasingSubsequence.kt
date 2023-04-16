package leetcode.dp

class LongestIncreasingSubsequence {
    fun lengthOfLIS(nums: IntArray): Int {
        val cache = IntArray(nums.size) { 1 }
        var maxVal = 1

        for (index in nums.size - 1 downTo 0) {
            val curNum = nums[index]

            for (prevIndex in index + 1 until nums.size) {
                val prevNum = nums[prevIndex]

                if (curNum < prevNum) {
                    cache[index] = maxOf(cache[index], cache[prevIndex] + 1)
                    maxVal = maxOf(maxVal, cache[index])
                }
            }
        }

        return maxVal
    }
}