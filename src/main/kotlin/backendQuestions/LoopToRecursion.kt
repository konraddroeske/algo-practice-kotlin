package backendQuestions

class LoopToRecursion {
    fun maxValueIterative(arr: IntArray): Int {
        var result = Int.MIN_VALUE

        for (cur in arr) {
            result = maxOf(result, cur)
        }

        return result
    }

    fun maxValueRecursive(arr: IntArray): Int {
        var curMax = Int.MIN_VALUE

        fun getMax(arr: IntArray, index: Int) {
            if (index >= arr.size) {
                return
            }

            curMax = maxOf(curMax, arr[index])

            getMax(arr, index + 1)
        }

        getMax(arr, 0)

        return curMax
    }
}