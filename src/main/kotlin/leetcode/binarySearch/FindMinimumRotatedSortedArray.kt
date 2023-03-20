package leetcode.binarySearch
class FindMinimumRotatedSortedArray {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        var result = Int.MAX_VALUE

        while (left <= right) {
            val mid = left + (right - left) / 2
            val cur = nums[mid]

            result = minOf(result, cur)

            // if in left sorted portion
            if (cur > nums[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return result
    }
}
