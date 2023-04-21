package leetcode.graphs

class WallsAndGates {

    fun updateWallsAndGates(rooms: Array<IntArray>) {
        // find gates
        val queue = ArrayDeque<Pair<Int, Int>>()
        val rows = rooms.size
        val cols = rooms[0].size

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (rooms[row][col] == 0) {
                    queue.add(Pair(row, col))
                }
            }
        }

        var distance = 1
        val directions = listOf(
            Pair(1, 0),
            Pair(-1, 0),
            Pair(0, 1),
            Pair(0, -1),
        )

        // from gates, do bfs
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val (curRow, curCol) = queue.removeFirst()

                for ((rowDir, colDir) in directions) {
                    val next = getRoom(
                        curRow + rowDir,
                        curCol + colDir,
                        rooms,
                        rows,
                        cols,
                    )

                    if (next != null) {
                        queue.add(next)
                        rooms[next.first][next.second] = minOf(rooms[next.first][next.second], distance)
                    }
                }
            }

            distance += 1
        }
    }

    fun getRoom(
        row: Int,
        col: Int,
        rooms: Array<IntArray>,
        rows: Int,
        cols: Int,
    ): Pair<Int, Int>? {
        val isOutOfBounds = row < 0 || row >= rows || col < 0 || col >= cols

        if (isOutOfBounds || rooms[row][col] != Int.MAX_VALUE) {
            return null
        }

        return Pair(row, col)
    }
}