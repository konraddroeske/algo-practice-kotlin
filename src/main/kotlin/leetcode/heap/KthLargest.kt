package leetcode.heap

import java.util.PriorityQueue

class KthLargest(val k: Int, nums: IntArray) {
    private val queue = PriorityQueue<Int>()

    init {
        for (num in nums) {
            add(num)
        }
    }
    fun add(`val`: Int): Int {
        if (queue.size < k) {
            queue.add(`val`)
        } else if (`val` > queue.peek()) {
            queue.poll()
            queue.add(`val`)
        }

        return queue.peek()
    }
}

// Init Time - O(n * log n)
// Add Time - O(log n)
