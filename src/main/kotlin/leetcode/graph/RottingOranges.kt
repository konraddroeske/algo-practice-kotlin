package leetcode.graph

// Time - O (rows * cols)
class RottingOranges {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var totalTime = 0
        val queue = ArrayDeque<Pair<Int, Int>>()
        var freshOranges = 0

        val rows = grid.size
        val cols = grid[0].size

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                val cur = grid[row][col]

                if (cur == 2) {
                    queue.add(Pair(row, col))
                }

                if (cur == 1) {
                    freshOranges += 1
                }
            }
        }

        val directions = listOf(
            Pair(1, 0),
            Pair(-1, 0),
            Pair(0, 1),
            Pair(0, -1),
        )

        while (queue.isNotEmpty() && freshOranges > 0) {
            repeat(queue.size) {
                val (curRow, curCol) = queue.removeFirst()

                for ((newRow, newCol) in directions) {
                    val orange = getFreshOrange(
                        curRow + newRow,
                        curCol + newCol,
                        grid,
                        rows,
                        cols,
                    )

                    if (orange != null) {
                        freshOranges -= 1
                        grid[orange.first][orange.second] = 2
                        queue.add(orange)
                    }
                }
            }

            totalTime += 1
        }

        return if (freshOranges == 0) totalTime else -1
    }

    fun getFreshOrange(
        row: Int,
        col: Int,
        grid: Array<IntArray>,
        rows: Int,
        cols: Int,
    ): Pair<Int, Int>? {
        val isOutOfBounds = row < 0 || row >= rows || col < 0 || col >= cols

        if (isOutOfBounds || grid[row][col] != 1
        ) {
            return null
        }

        return Pair(row, col)
    }
}
