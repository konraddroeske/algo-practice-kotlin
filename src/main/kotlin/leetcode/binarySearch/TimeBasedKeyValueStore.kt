package leetcode.binarySearch

class TimeBasedKeyValueStore {
    val timeMap = HashMap<String, MutableList<Pair<Int, String>>>()
        .withDefault {
            mutableListOf()
        }
    fun set(key: String, value: String, timestamp: Int) {
        val arr = timeMap.getValue(key)
        arr.add(Pair(timestamp, value))

        timeMap[key] = arr
    }

    fun get(key: String, timestamp: Int): String {
        val arr = timeMap.getValue(key)

        if (arr.isEmpty()) return ""
        if (timestamp < arr.first().first) return ""
        if (timestamp > arr.last().first) return arr.last().second

        var left = 0
        var right = arr.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            val (midTime, midVal) = arr[mid]

            if (midTime == timestamp) {
                return midVal
            } else if (timestamp < midTime) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return arr[minOf(left, right)].second
    }
}
