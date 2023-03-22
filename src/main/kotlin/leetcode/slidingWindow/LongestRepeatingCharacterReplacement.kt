package leetcode.slidingWindow

class LongestRepeatingCharacterReplacement {
    private fun isOverMax(
        right: Int,
        left: Int,
        counter: IntArray,
        k: Int,
    ):
        Boolean {
        if (counter.isEmpty()) return false
        val windowSize = right - left + 1
        val maxQty = counter.max()

        return windowSize - maxQty > k
    }
    fun characterReplacement(s: String, k: Int): Int {
        val counter = IntArray(26)
        var result = 0
        var leftIndex = 0

        for ((rightIndex, curChar) in s.withIndex()) {
            counter[curChar.code - 65] += 1

            while (isOverMax(rightIndex, leftIndex, counter, k)) {
                val leftChar = s[leftIndex]
                counter[leftChar.code - 65] -= 1
                leftIndex += 1
            }

            result = maxOf(result, rightIndex - leftIndex + 1)
        }

        return result
    }
}
