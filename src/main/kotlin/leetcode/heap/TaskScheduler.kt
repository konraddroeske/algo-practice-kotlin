package leetcode.heap

import java.util.PriorityQueue

class TaskScheduler {
    fun leastIntervalOptimized(tasks: CharArray, n: Int): Int {
        val freq = IntArray(26)
        var max = 0
        var maxCount = 0

        for (task in tasks) {
            freq[task - 'A'] += 1

            if (freq[task - 'A'] > max) {
                max = freq[task - 'A']
                maxCount = 1
            } else if (freq[task - 'A'] == max) {
                maxCount += 1
            }
        }

        val partCount = max - 1
        val partLength = n - (maxCount - 1)
        val emptySlots = partCount * partLength

        val availTasks = tasks.size - max * maxCount
        val idles = Math.max(0, emptySlots - availTasks)

        return tasks.size + idles
    }
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val maxHeap = PriorityQueue<Triple<Char, Int, Int>> { a, b ->
            b.second - a.second
        }
        val deque = ArrayDeque<Triple<Char, Int, Int>>()

        tasks.groupBy { it }.forEach {
            maxHeap.add(Triple(it.key, it.value.size, 1))
        }

        var curTime = 0

        while (maxHeap.size > 0 || deque.size > 0) {
            curTime += 1

            if (maxHeap.size > 0) {
                val curTask = maxHeap.poll()

                if (curTask.second > 1) {
                    deque.add(
                        curTask.copy(
                            second = curTask.second - 1,
                            third = curTime + n,
                        ),
                    )
                }
            }

            if (deque.size > 0 && curTime >= deque.first().third) {
                maxHeap.add(deque.removeFirst())
            }
        }

        return curTime
    }
}