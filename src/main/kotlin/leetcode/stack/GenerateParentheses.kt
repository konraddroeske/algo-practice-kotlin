
class GenerateParentheses {
    fun generateParentheses(n: Int): List<String> {
        val parens = StringBuilder()
        val result = mutableListOf<String>()

        fun backtrack(open: Int, close: Int) {
            if (open == n && close == n) {
                result.add(parens.toString())
                return
            }

            if (open < n) {
                parens.append("(")
                backtrack(open + 1, close)
                parens.deleteCharAt(parens.length - 1)
            }

            if (close < open) {
                parens.append(")")
                backtrack(open, close + 1)
                parens.deleteCharAt(parens.length - 1)
            }
        }

        backtrack(0, 0)

        return result
    }
}
