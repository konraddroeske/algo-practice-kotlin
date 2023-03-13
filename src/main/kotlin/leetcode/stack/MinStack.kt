class MinStack() {
    private val stack = mutableListOf<Int>()
    private var minValues = mutableListOf<Int>()

    fun push(`val`: Int) {
        if (minValues.isEmpty()) {
            minValues.add(`val`)
        } else {
            if (`val` <= minValues.last()) {
                minValues.add(`val`)
            }
        }

        stack.add(`val`)
    }

    fun pop() {
        val top = top()

        if (minValues.last() == top) {
            minValues.removeAt(minValues.size - 1)
        }

        stack.removeAt(stack.size - 1)
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minValues.last()
    }
}
