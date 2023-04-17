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
                val temp = nums[pointer]
                nums[pointer] = nums[index]
                nums[index] = temp
                pointer += 1
            }
        }

        val temp = nums[pointer]
        nums[pointer] = pivotValue
        nums[right] = temp

        if (pointer > k) {
            return quickSelect(left, pointer - 1, nums, k)
        }

        if (pointer < k) {
            return quickSelect(pointer + 1, right, nums, k)
        }

        return nums[pointer]
    }
}

// Time - O(n + n/2 + n/4...) = O(2 * n) = O(n)