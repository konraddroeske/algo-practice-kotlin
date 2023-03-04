
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
