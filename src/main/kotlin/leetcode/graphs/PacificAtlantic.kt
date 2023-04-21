package leetcode.graphs

// Time - O(rows * cols)
class PacificAtlantic {
    fun getPacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val rows = heights.size
        val cols = heights[0].size

        val pacific = mutableSetOf<List<Int>>()
        val atlantic = mutableSetOf<List<Int>>()

        for (row in 0 until rows) {
            dfs(0, row, 0, pacific, heights, rows, cols)
            dfs(0, row, heights[0].size - 1, atlantic, heights, rows, cols)
        }

        for (col in 0 until cols) {
            dfs(0, 0, col, pacific, heights, rows, cols)
            dfs(0, heights.size - 1, col, atlantic, heights, rows, cols)
        }

        return pacific.intersect(atlantic).toList()
    }

    fun dfs(
        prevHeight: Int,
        row: Int,
        col: Int,
        visited: MutableSet<List<Int>>,
        heights: Array<IntArray>,
        rows: Int,
        cols: Int,
    ) {
        val isOutOfBounds = row < 0 || row >= rows || col < 0 || col >= cols

        if (isOutOfBounds ||
            visited.contains(listOf(row, col)) ||
            prevHeight > heights[row][col]
        ) {
            return
        }

        visited.add(listOf(row, col))
        val curHeight = heights[row][col]

        dfs(curHeight, row + 1, col, visited, heights, rows, cols)
        dfs(curHeight, row - 1, col, visited, heights, rows, cols)
        dfs(curHeight, row, col + 1, visited, heights, rows, cols)
        dfs(curHeight, row, col - 1, visited, heights, rows, cols)
    }
}
