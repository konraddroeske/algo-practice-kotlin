import java.util.NoSuchElementException

class ValidParentheses {
    // Time - O(n)
    fun isValid(s: String): Boolean {
        // stack to track open brackets
        val stack = ArrayDeque<Char>()
        // hashmap - close to open
        val brackets = hashMapOf(
            ')' to '(',
            ']' to '[',
            '}' to '{',
        )

        // iterate through
        for (curBracket in s) {
            // open bracket
            if (!brackets.contains(curBracket)) {
                stack.add(curBracket)
            } else {
                // close bracket
                try {
                    val matchedBracket = stack.removeLast()
                    if (brackets.getValue(curBracket) != matchedBracket) {
                        return false
                    }
                } catch (e: NoSuchElementException) {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}
