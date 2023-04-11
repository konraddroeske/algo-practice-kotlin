package leetcode.backtracking

class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val visited = Array(board.size) { BooleanArray(board[0].size) }

        for ((rowIndex, row) in board.withIndex()) {
            for (colIndex in row.indices) {
                if (backtrack(rowIndex, colIndex, 0, board, word, visited)) {
                    return true
                }
            }
        }

        return false
    }

    fun backtrack(
        row: Int,
        col: Int,
        index: Int,
        board: Array<CharArray>,
        word: String,
        visited: Array<BooleanArray>,
    ): Boolean {
        if (index == word.length) {
            return true
        }

        if (
            row < 0 ||
            col < 0 ||
            row >= board.size ||
            col >= board[0].size ||
            visited[row][col] ||
            word[index] != board[row][col]
        ) {
            return false
        }

        visited[row][col] = true

        val result = backtrack(row - 1, col, index + 1, board, word, visited) ||
            backtrack(row + 1, col, index + 1, board, word, visited) ||
            backtrack(row, col - 1, index + 1, board, word, visited) ||
            backtrack(row, col + 1, index + 1, board, word, visited)

        visited[row][col] = false

        return result
    }
}

// Time Complexity - O(n * m * 4^n)