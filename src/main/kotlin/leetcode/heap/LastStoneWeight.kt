package leetcode.heap

import java.util.PriorityQueue

class LastStoneWeight {
    fun getLastStoneWeight(stones: IntArray): Int {
        // max heap
        val queue = PriorityQueue<Int> { a, b -> b - a }

        stones.forEach { queue.add(it) }

        while (queue.size > 1) {
            // x <= y in weight
            val y = queue.poll()
            val x = queue.poll()

            // x == y, both destroyed
            // x != y, x destroyed, y = y - x
            if (y == x) {
                continue
            } else {
                queue.add(y - x)
            }
        }

        if (queue.size == 0) return 0

        return queue.peek()
    }
}
