package leetcode.dp

class PartitionEqualSubsetSum {
    fun canPartition(nums: IntArray): Boolean {
        // if odd, return false
        val total = nums.sum()

        if (total % 2 != 0) {
            return false
        }

        // create array for knapsack problem, with half of total sum
        val halfWeight = total / 2
        val resultArr = Array(nums.size) { IntArray(halfWeight + 1) }

        for ((rowIndex, row) in resultArr.withIndex()) {
            val itemWeight = nums[rowIndex]

            for ((curWeight, _) in row.withIndex()) {
                if (itemWeight <= curWeight) {
                    val case1 = if (rowIndex > 0) {
                        resultArr[rowIndex - 1 ][curWeight]
                    } else {
                        0
                    }

                    val diffWeight = curWeight - itemWeight
                    val diffValue = if (rowIndex > 0) {
                        resultArr[rowIndex - 1 ][diffWeight]
                    } else {
                        0
                    }

                    val case2 = itemWeight + diffValue
                    val curValue = maxOf(case1, case2)

                    resultArr[rowIndex][curWeight] = curValue

                    if (curValue == halfWeight) {
                        return true
                    }
                } else {
                    if (rowIndex > 0) {
                        resultArr[rowIndex][curWeight] = resultArr[rowIndex - 1][curWeight]
                    }
                }
            }
        }

        return false
    }

    fun canPartitionOptimized(nums: IntArray): Boolean {
        val total = nums.sum()

        if (total % 2 != 0) return false

        val target = total / 2
        val dpArr = BooleanArray(target + 1) { false }
        dpArr[0] = true

        nums.forEach { num ->
            for (index in target downTo num) {
                dpArr[index] = dpArr[index] || dpArr[index - num]
            }
        }

        return dpArr[target]
    }
}

fun main() {
    val solution = PartitionEqualSubsetSum()

    val nums1 = intArrayOf(1, 5, 11, 5)
    val result1 = solution.canPartitionOptimized(nums1)
    println("result1: $result1")

    val nums2 = intArrayOf(1, 2, 3, 5)
    val result2 = solution.canPartitionOptimized(nums2)
    println("result2: $result2")

    val nums3 = intArrayOf(14, 9, 8, 4, 3, 2)
    val result3 = solution.canPartitionOptimized(nums3)
    println("result3: $result3")
}
