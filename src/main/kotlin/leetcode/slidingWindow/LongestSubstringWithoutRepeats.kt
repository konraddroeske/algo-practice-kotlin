
class LongestSubstringWithoutRepeats {
    fun lengthOfLongestSubstring(s: String): Int {
        val repeats = HashSet<Char>()
        var result = 0
        var leftIndex = 0

        for ((rightIndex, rightChar) in s.withIndex()) {
            while (repeats.contains(rightChar)) {
                repeats.remove(s[leftIndex])
                leftIndex += 1
            }

            repeats.add(s[rightIndex])
            result = maxOf(result, rightIndex - leftIndex + 1)
        }

        return result
    }
}
