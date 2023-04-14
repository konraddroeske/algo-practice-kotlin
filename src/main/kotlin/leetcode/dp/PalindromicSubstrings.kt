package leetcode.dp

class PalindromicSubstrings {
    fun countSubstrings(s: String): Int {
        var result = 0

        for (index in s.indices) {
            result += helper(s, index, index)
            result += helper(s, index, index + 1)
        }

        return result
    }

    fun helper(s: String, l: Int, r: Int): Int {
        var count = 0
        var left = l
        var right = r

        while (left >= 0 && right < s.length && s[left] == s[right]) {
            count += 1
            left -= 1
            right += 1
        }

        return count
    }
}