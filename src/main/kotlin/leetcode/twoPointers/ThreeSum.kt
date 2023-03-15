package leetcode.twoPointers
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()

        for ((i, iVal) in nums.withIndex()) {
            // Skip iVal repeats
            if (i > 0 && iVal == nums[i - 1]) {
                continue
            }

            var j = i + 1
            var k = nums.size - 1

            while (j < k) {
                val jVal = nums[j]
                val kVal = nums[k]
                val sumVal = iVal + jVal + kVal

                if (sumVal == 0) {
                    result.add(listOf(iVal, jVal, kVal))
                    j += 1

                    // Skip jVal repeats
                    while (nums[j] == nums[j - 1] && j < k) {
                        j += 1
                    }
                } else if (sumVal > 0) {
                    k -= 1
                } else {
                    j += 1
                }
            }
        }

        return result
    }
}
