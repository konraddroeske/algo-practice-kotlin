package leetcode.binarySearch
class SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            val midVal = nums[mid]

            if (midVal == target) {
                return mid
            }

            if (midVal >= nums[left]) {
                // cur is left arr
                if (target > midVal || target < nums[left]) {
                    // target is larger or in right arr
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            } else {
                // cur is right arr
                if (target < midVal || target > nums[right]) {
                    // target is smaller or in left arr
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
        }

        return -1
    }
}
