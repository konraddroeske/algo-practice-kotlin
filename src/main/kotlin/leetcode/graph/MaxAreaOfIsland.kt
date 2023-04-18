package leetcode.graph

// Time - O(rows * cols)
class MaxAreaOfIsland {
    fun getMaxAreaOfIsland(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var maxArea = 0

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                maxArea = maxOf(maxArea, dfs(row, col, grid, rows, cols))
            }
        }

        return maxArea
    }

    fun dfs(row: Int, col: Int, grid: Array<IntArray>, rows: Int, cols: Int): Int {
        val isOutOfBounds = row < 0 || row >= rows || col < 0 || col >= cols

        if (isOutOfBounds || grid[row][col] == 0) {
            return 0
        }

        grid[row][col] = 0

        return 1 + dfs(row + 1, col, grid, rows, cols) +
            dfs(row - 1, col, grid, rows, cols) +
            dfs(row, col + 1, grid, rows, cols) +
            dfs(row, col - 1, grid, rows, cols)
    }
}