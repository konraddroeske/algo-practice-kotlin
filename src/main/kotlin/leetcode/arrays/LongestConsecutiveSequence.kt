
class LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (num in nums) set.add(num)

        var result = 0

        for (num in nums) {
            if (set.contains(num - 1)) continue

            var counter = 0
            var cur = num

            while (set.contains(cur)) {
                counter += 1
                cur += 1
            }

            result = maxOf(result, counter)
        }

        return result
    }
}
