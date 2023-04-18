package leetcode.graph

class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        var counter = 0
        val rows = grid.size
        val cols = grid[0].size

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (grid[row][col] == '1') {
                    counter += 1
                    traverse(row, col, grid, rows, cols)
                }
            }
        }

        return counter
    }

    fun traverse(
        row: Int,
        col: Int,
        grid: Array<CharArray>,
        rows: Int,
        cols: Int,
    ) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return
        }

        val cur = grid[row][col]

        if (cur == '0') {
            return
        }

        grid[row][col] = '0'

        traverse(row + 1, col, grid, rows, cols)
        traverse(row - 1, col, grid, rows, cols)
        traverse(row, col + 1, grid, rows, cols)
        traverse(row, col - 1, grid, rows, cols)
    }
}