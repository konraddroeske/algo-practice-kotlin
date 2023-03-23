package leetcode.slidingWindow
class PermutationInString {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1Counter = IntArray(26)
        val s2Counter = IntArray(26)
        val diff = 'a'.code
        var matches = 0

        for (char in s1) {
            s1Counter[char.code - diff] += 1
        }

        var leftIndex = 0

        for ((rightIndex, char) in s2.withIndex()) {
            s2Counter[char.code - diff] += 1

            if (s2Counter[char.code - diff] <= s1Counter[char.code - diff]) {
                matches += 1
            }

            while (rightIndex - leftIndex + 1 > s1.length) {
                val leftChar = s2[leftIndex]
                s2Counter[leftChar.code - diff] -= 1
                leftIndex += 1

                if (s2Counter[leftChar.code - diff] < s1Counter[leftChar.code - diff]) {
                    matches -= 1
                }
            }

            if (matches == s1.length) return true
        }

        return false
    }
}
