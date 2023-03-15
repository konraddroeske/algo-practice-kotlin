package leetcode.stack

class LargestRectangleInHistogram {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val stack = mutableListOf<Pair<Int, Int>>()

        for ((curIndex, curHeight) in heights.withIndex()) {
            maxArea = maxOf(maxArea, curHeight)
            var startIndex = curIndex

            while (stack.isNotEmpty() && curHeight < stack.last().second) {
                val (prevIndex, prevHeight) = stack.removeAt(stack.size - 1)
                val curArea = prevHeight * (curIndex - prevIndex)

                startIndex = prevIndex
                maxArea = maxOf(maxArea, curArea)
            }

            stack.add(Pair(startIndex, curHeight))
        }

        while (stack.isNotEmpty()) {
            val (curIndex, curHeight) = stack.removeAt(stack.size - 1)
            val curArea = (heights.size - curIndex) * curHeight
            maxArea = maxOf(maxArea, curArea)
        }

        return maxArea
    }
}
