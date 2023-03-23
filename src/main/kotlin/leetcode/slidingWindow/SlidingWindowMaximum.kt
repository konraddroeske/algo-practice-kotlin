package leetcode.slidingWindow
class SlidingWindowMaximum {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val deque = ArrayDeque<Int>()
        val result = IntArray(nums.size - k + 1)

        for ((index, num) in nums.withIndex()) {
            val windowStart = index - (k - 1)

            while (deque.isNotEmpty() && deque.first() < windowStart) {
                // peek()
                deque.removeFirst()
            }

            while (deque.isNotEmpty() && nums[deque.last()] < num) {
                // peekLast()
                deque.removeLast()
            }

            deque.add(index)

            if (windowStart >= 0) {
                result[windowStart] = nums[deque.first()]
                // use peek()
            }
        }

        return result
    }
}
