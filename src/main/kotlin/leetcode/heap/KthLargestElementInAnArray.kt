package leetcode.heap

class KthLargestElementInAnArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pos = nums.size - k
        return quickSelect(0, nums.size - 1, nums, pos)
    }

    fun quickSelect(left: Int, right: Int, nums: IntArray, k: Int): Int {
        var pointer = left
        val pivotValue = nums[right]

        for (index in left until right) {
            if (nums[index] <= pivotValue) {
                nums[pointer] = nums[index].apply { nums[index] = nums[pointer] }
                pointer += 1
            }
        }

        nums[pointer] = nums[right].apply { nums[right] = nums[pointer] }

        return when {
            pointer > k -> quickSelect(left, pointer - 1, nums, k)
            pointer < k -> quickSelect(pointer + 1, right, nums, k)
            else -> nums[pointer]
        }
    }
}

// Time - O(n + n/2 + n/4...) = O(2 * n) = O(n)