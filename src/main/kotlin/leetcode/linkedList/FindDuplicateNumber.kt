package leetcode.linkedList

class FindDuplicateNumber {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[slow]

        // Find cycle
        while (slow != fast) {
            fast = nums[nums[fast]]
            slow = nums[slow]
        }

        var start = 0

        // Find cycle entrypoint
        while (start != slow) {
            start = nums[start]
            slow = nums[slow]
        }

        return start
    }
}