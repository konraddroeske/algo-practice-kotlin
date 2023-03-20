package leetcode.binarySearch
class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = (right - left) / 2 + left
            val cur = nums[mid]

            if (cur == target) {
                return mid
            } else if (target < cur) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return -1
    }
}
