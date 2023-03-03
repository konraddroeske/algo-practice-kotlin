import kotlin.math.abs

class ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var minDiff = Int.MAX_VALUE
        var minSum = 0

        for ((index, num) in nums.withIndex()) {
            var left = index + 1
            var right = nums.size - 1

            while (left < right) {
                val curSum = num + nums[left] + nums[right]

                if (curSum == target) {
                    return curSum
                }

                val curDiff = abs(target - curSum)

                if (curDiff < minDiff) {
                    minDiff = curDiff
                    minSum = curSum
                }

                if (curSum < target) {
                    left += 1
                } else {
                    right -= 1
                }
            }
        }

        return minSum
    }
}
