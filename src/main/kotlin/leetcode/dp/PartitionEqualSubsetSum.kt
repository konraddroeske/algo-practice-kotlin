package leetcode.dp

class PartitionEqualSubsetSum {
    fun canPartition(nums: IntArray): Boolean {
        val total = nums.sum()

        if (total % 2 == 1) {
            return false
        }

        val targets = mutableSetOf(total / 2)

        for (num in nums) {
            val newTargets = mutableSetOf<Int>()

            if (targets.contains(num)) return true

            for (target in targets) {
                if (num < target) {
                    newTargets.add(target - num)
                }
            }

            targets += newTargets
        }

        return false
    }
}
