package leetcode.dp

class HouseRobber {
    fun rob(nums: IntArray): Int {
        var prev1 = 0
        var prev2 = 0

        for (num in nums) {
            val case1 = num + prev2
            val case2 = prev1

            prev2 = prev1
            prev1 = maxOf(case1, case2)
        }

        return maxOf(prev1, prev2)
    }
}