package leetcode.dp
class WordBreak {
    fun isWordBreak(s: String, wordDict: List<String>): Boolean {
        val result = BooleanArray(s.length + 1) { false }
        result[s.length] = true

        for (index in s.length - 1 downTo 0) {
            for (word in wordDict) {
                if (index + word.length <= s.length &&
                    s.substring(index, index + word.length) == word
                ) {
                    result[index] = result[index + word.length]
                }

                if (result[index]) {
                    break
                }
            }
        }

        return result[0]
    }
}