package leetcode.graph

// Time - O (n * m)
class SurroundedRegions {
    fun solve(board: Array<CharArray>) {
        val rows = board.size
        val cols = board[0].size

        for (row in 0 until rows) {
            dfs(row, 0, board, rows, cols)
            dfs(row, cols - 1, board, rows, cols)
        }

        for (col in 0 until cols) {
            dfs(0, col, board, rows, cols)
            dfs(rows - 1, col, board, rows, cols)
        }

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X'
                }

                if (board[row][col] == 'Z') {
                    board[row][col] = 'O'
                }
            }
        }
    }

    fun dfs(
        row: Int,
        col: Int,
        board: Array<CharArray>,
        rows: Int,
        cols: Int,
    ) {
        val isOutOfBounds = row < 0 || row >= rows || col < 0 || col >= cols

        if (isOutOfBounds || board[row][col] != 'O') {
            return
        }

        board[row][col] = 'Z'

        dfs(row + 1, col, board, rows, cols)
        dfs(row - 1, col, board, rows, cols)
        dfs(row, col + 1, board, rows, cols)
        dfs(row, col - 1, board, rows, cols)
    }
}