class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val result = StringBuilder()

        s.forEach {
            if (it.isLetter() || it.isDigit()) {
                result.append(it.lowercase())
            }
        }

        return result.toString() == result.reversed().toString()
    }

    fun isPalindromeTwoPointer(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            val leftChar = s[left]
            val rightChar = s[right]

            if (!leftChar.isLetter() && !leftChar.isDigit()) {
                left += 1
                continue
            }

            if (!rightChar.isLetter() && !rightChar.isDigit()) {
                right -= 1
                continue
            }

            if (leftChar.lowercase() != rightChar.lowercase()) {
                return false
            }

            left += 1
            right -= 1
        }

        return true
    }
}
