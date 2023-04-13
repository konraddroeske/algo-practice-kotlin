package leetcode.dp

class HouseRobber2 {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        val res1 = IntArray(nums.size - 1)
        val res2 = IntArray(nums.size - 1)

        for ((index, num) in nums.withIndex()) {
            if (index < nums.size - 1) {
                val prev1 = if (index >= 1) res1[index - 1] else 0
                val prev2 = if (index >= 2) res1[index - 2] else 0

                res1[index] = maxOf(num + prev2, prev1)
            }

            if (index > 0) {
                val res2Index = index - 1
                val prev1 = if (res2Index >= 1) res2[res2Index - 1] else 0
                val prev2 = if (res2Index >= 2) res2[res2Index - 2] else 0

                res2[res2Index] = maxOf(num + prev2, prev1)
            }
        }

        return maxOf(res1[res1.size - 1], res2[res2.size - 1])
    }
}