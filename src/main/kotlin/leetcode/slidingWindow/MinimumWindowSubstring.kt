
import kotlin.collections.HashMap

class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        if (s.isEmpty() || t.isEmpty()) return ""

        val tCounter = HashMap<Char, Int>().withDefault { 0 }
        val windowCounter = HashMap<Char, Int>().withDefault { 0 }

        for (char in t) {
            tCounter[char] = tCounter.getValue(char) + 1
        }

        val required = tCounter.size
        var isFormed = 0

        var left = 0
        var right = 0
        var results = Triple(Int.MAX_VALUE, 0, 0)

        while (right < s.length) {
            val rightChar = s[right]
            windowCounter[rightChar] = windowCounter.getValue(rightChar) + 1

            if (tCounter.containsKey(rightChar) &&
                tCounter.getValue(rightChar) == windowCounter.getValue(rightChar)
            ) {
                isFormed += 1
            }

            while (left <= right && isFormed == required) {
                val leftChar = s[left]

                if (right - left + 1 < results.first) {
                    results = Triple(right - left + 1, left, right)
                }

                windowCounter[leftChar] = windowCounter.getValue(leftChar) - 1

                if (tCounter.containsKey(leftChar) &&
                    windowCounter.getValue(leftChar) < tCounter.getValue(leftChar)
                ) {
                    isFormed -= 1
                }

                left += 1
            }

            right += 1
        }

        return if (results.first == Int.MAX_VALUE) {
            ""
        } else {
            s.slice(
                IntRange
                (results.second, results.third),
            )
        }
    }
}
