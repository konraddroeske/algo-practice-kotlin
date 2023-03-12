
class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowMap = HashMap<Int, MutableSet<Char>>()
        val colMap = HashMap<Int, MutableSet<Char>>()
        val blockMap = HashMap<Int, MutableSet<Char>>()

        for (rowIndex in board.indices) {
            for (colIndex in board.indices) {
                val cur = board[rowIndex][colIndex]

                if (!cur.isDigit()) continue

                // check row
                val rowSet = rowMap.getOrPut(rowIndex) { mutableSetOf() }
                if (rowSet.contains(cur)) return false
                rowSet.add(cur)

                // check col
                val colSet = colMap.getOrPut(colIndex) { mutableSetOf() }
                if (colSet.contains(cur)) return false
                colSet.add(cur)

                // check block
                val blockIndex = ((rowIndex / 3) * 3) + (colIndex / 3)
                val blockSet = blockMap.getOrPut(blockIndex) { mutableSetOf() }
                if (blockSet.contains(cur)) return false
                blockSet.add(cur)
            }
        }

        return true
    }
}
