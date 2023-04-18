package leetcode.heap

import java.util.PriorityQueue

class FindMedianFromDataStream {
    val maxHeap = PriorityQueue<Int>() { a, b -> b - a }
    val minHeap = PriorityQueue<Int>() { a, b -> a - b }

    // Time - O(log n)
    fun addNum(num: Int) {
        // add to correct side
        val maxHeapVal = maxHeap.peek()

        if (maxHeapVal == null || num <= maxHeapVal) {
            maxHeap.add(num)
        } else {
            minHeap.add(num)
        }

        // balance size
        val maxHeapSize = maxHeap.size
        val minHeapSize = minHeap.size

        if (maxHeapSize - minHeapSize > 1) {
            val maxHead = maxHeap.poll()
            minHeap.add(maxHead)
        } else if (minHeapSize - maxHeapSize > 0) {
            val minHead = minHeap.poll()
            maxHeap.add(minHead)
        }
    }

    // Time - O(1)
    fun findMedian(): Double {
        if (maxHeap.size > minHeap.size) {
            return maxHeap.peek().toDouble()
        }

        return (maxHeap.peek().toDouble() + minHeap.peek().toDouble()) / 2
    }
}