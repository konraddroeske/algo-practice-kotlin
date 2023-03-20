package leetcode.binarySearch
class SearchA2DMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val rows = matrix.size
        val cols = matrix[0].size

        var left = 0
        var right = rows * cols - 1

        while (left <= right) {
            val mid = (right - left) / 2 + left

            val curRow = mid / cols
            val curCol = mid % cols
            val cur = matrix[curRow][curCol]

            if (target == cur) {
                return true
            } else if (target < cur) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return false
    }
}
