package leetcode.dp

class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        var result = ""

        for (index in s.indices) {
            var left = index
            var right = index

            while (left >= 0 && right < s.length && s[left] == s[right]) {
                if (right - left + 1 > result.length) {
                    result = s.substring(left, right + 1)
                }

                left -= 1
                right += 1
            }

            // EVEN
            left = index
            right = index + 1

            while (left >= 0 && right < s.length && s[left] == s[right]) {
                if (right - left + 1 > result.length) {
                    result = s.substring(left, right + 1)
                }

                left -= 1
                right += 1
            }
        }

        return result
    }
}