package leetcode.backtracking

class LetterCombinationsOfAPhoneNumber {
    private val phoneMap = hashMapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz",
    )

    val result = mutableListOf<String>()
    val cur = StringBuilder()

    fun letterCombinations(digits: String): List<String> {
        if (digits.isNotEmpty()) {
            backtrack(0, digits)
        }

        return result.toList()
    }

    private fun backtrack(index: Int, digits: String) {
        if (cur.length == digits.length) {
            result.add(cur.toString())
            return
        }

        val num = digits[index]
        val letters = phoneMap[num] ?: return

        for (letter in letters) {
            cur.append(letter)
            backtrack(index + 1, digits)
            cur.deleteCharAt(cur.length - 1)
        }
    }
}

// Time Complexity - O(length of output string * number of outputs)
// -> O(n * 4^n)
// Round up because some numbers have 4 choices