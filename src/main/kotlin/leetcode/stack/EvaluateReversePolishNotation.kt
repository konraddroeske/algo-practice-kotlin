class EvaluateReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        tokens.forEach {
            when (it) {
                "+" -> stack.add(stack.removeLast() + stack.removeLast())
                "-" -> {
                    val y = stack.removeLast()
                    stack.add(stack.removeLast() - y)
                }
                "*" -> stack.add(stack.removeLast() * stack.removeLast())
                "/" -> {
                    val y = stack.removeLast()
                    stack.add(stack.removeLast() / y)
                }
                else -> stack.add(it.toInt())
            }
        }

        return stack.removeLast()
    }
}
