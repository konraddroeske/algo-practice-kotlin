package leetcode.slidingWindow

class LongestRepeatingCharacterReplacement {
    private fun isOverMax(
        right: Int,
        left: Int,
        maxFreq: Int,
        k: Int,
    ): Boolean {
        val windowSize = right - left + 1
        return windowSize - maxFreq > k
    }

    fun characterReplacement(s: String, k: Int): Int {
        val counter = IntArray(26)
        var result = 0
        var leftIndex = 0
        var maxFreq = 0

        for ((rightIndex, curChar) in s.withIndex()) {
            counter[curChar.toInt() - 65] += 1
            maxFreq = maxOf(maxFreq, counter[curChar.toInt() - 65])

            while (isOverMax(rightIndex, leftIndex, maxFreq, k)) {
                val leftChar = s[leftIndex]
                counter[leftChar.toInt() - 65] -= 1
                leftIndex += 1
            }

            result = maxOf(result, rightIndex - leftIndex + 1)
        }

        return result
    }
}
