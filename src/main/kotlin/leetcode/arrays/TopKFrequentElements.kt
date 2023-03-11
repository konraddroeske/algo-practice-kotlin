import java.util.PriorityQueue

class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        return nums
            .groupBy { it }
            .entries
            .sortedByDescending { it.value.size }
            .map { it.key }
            .slice(0 until k)
            .toIntArray()
    }

    fun topKFrequentHeap(nums: IntArray, k: Int): IntArray {
        val grouped = nums.groupBy { it }

        val maxHeap = PriorityQueue<Pair<Int, Int>> { a, b ->
            b.second - a.second
        }

        for ((key, value) in grouped.entries) {
            maxHeap.add(Pair(key, value.size))
        }

        var result = intArrayOf()

        for (index in 0 until k) {
            val maxRes = maxHeap.poll().first
            result += intArrayOf(maxRes)
        }

        return result
    }
}
