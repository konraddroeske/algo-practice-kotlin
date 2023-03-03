import java.util.*

class LongestSubstringWithoutRepeats {
    fun lengthOfLongestSubstring(s: String): Int {
        val seen = HashSet<Char>()
        var left = 0
        var max = 0

        for (c in s) {
            while (seen.contains(c)) {
                seen.remove(s[left])
                left += 1
            }

            seen.add(c)
            max = maxOf(max, seen.size)
        }

        return max
    }
}

fun main() {
    val solution = LongestSubstringWithoutRepeats()

    val input1 = "abcabcbb"
    val result1 = solution.lengthOfLongestSubstring(input1)
    println("result1: $result1")

    val input2 = "pwwkew"
    val result2 = solution.lengthOfLongestSubstring(input2)
    println("result2: $result2")

    val input3 = "qrsvbspk"
    val result3 = solution.lengthOfLongestSubstring(input3)
    println("result3: $result3")
}
