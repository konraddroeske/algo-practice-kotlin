package leetcode.dp

class MinCostClimbingStairs {
    fun minCost(cost: IntArray): Int {
        var prev1Step = 0
        var prev2Step = 0

        for (index in 0..cost.size) {
            val curCost = if (index < cost.size) cost[index] else 0

            val case1 = curCost + prev1Step
            val case2 = curCost + prev2Step

            prev2Step = prev1Step
            prev1Step = minOf(case1, case2)
        }

        return prev1Step
    }
}