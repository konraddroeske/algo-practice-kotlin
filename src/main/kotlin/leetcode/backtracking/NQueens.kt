package leetcode.backtracking

class NQueens {
    val cols = mutableSetOf<Int>()
    val posDiag = mutableSetOf<Int>()
    val negDiag = mutableSetOf<Int>()
    val results = mutableListOf<List<String>>()
    fun solveNQueens(n: Int): List<List<String>> {
        val board = Array(n) { StringBuilder(".".repeat(n)) }
        backtracking(0, board, n)
        return results.toList()
    }

    fun backtracking(
        row: Int,
        board: Array<StringBuilder>,
        n: Int,
    ) {
        if (row == n) {
            results.add(board.map { it.toString() })
            return
        }

        for (col in 0 until n) {
            if (col in cols || (row + col) in posDiag || (row - col) in negDiag) {
                continue
            }

            cols.add(col)
            posDiag.add(row + col)
            negDiag.add(row - col)
            board[row][col] = 'Q'

            backtracking(row + 1, board, n)

            cols.remove(col)
            posDiag.remove(row + col)
            negDiag.remove(row - col)
            board[row][col] = '.'
        }
    }
}