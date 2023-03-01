package leetcode.graph

import java.util.*

fun orangesRotting(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) {
        return -1
    }

    val height = grid.size
    val width = grid[0].size

    val bfsQueue = LinkedList<Triple<Int, Int, Int>>()
    val visited = mutableSetOf<Pair<Int, Int>>()
    var totalOranges = 0
    var maxDistance = 0

    for ((rowIndex, row) in grid.withIndex()) {
        for ((colIndex, item) in row.withIndex()) {
            if (item == 2) {
                bfsQueue.add(Triple(rowIndex, colIndex, 0))
                visited.add(Pair(rowIndex, colIndex))
            }

            if (item == 1 || item == 2) {
                totalOranges += 1
            }
        }
    }

    while (bfsQueue.isNotEmpty()) {
        val (rowIndex, colIndex, distance) = bfsQueue.remove()
        val newDistance = distance + 1
        maxDistance = maxOf(maxDistance, distance)

        if (rowIndex > 0) {
            val up = grid[rowIndex - 1][colIndex]

            if (up == 1 && !visited.contains(Pair(rowIndex - 1, colIndex))) {
                bfsQueue.add(Triple(rowIndex - 1, colIndex, newDistance))
                visited.add(Pair(rowIndex - 1, colIndex))
            }
        }

        if (rowIndex < height - 1) {
            val down = grid[rowIndex + 1][colIndex]

            if (down == 1 && !visited.contains(Pair(rowIndex + 1, colIndex))) {
                bfsQueue.add(Triple(rowIndex + 1, colIndex, newDistance))
                visited.add(Pair(rowIndex + 1, colIndex))
            }
        }

        if (colIndex > 0) {
            val left = grid[rowIndex][colIndex - 1]

            if (left == 1 && !visited.contains(Pair(rowIndex, colIndex - 1))) {
                bfsQueue.add(Triple(rowIndex, colIndex - 1, newDistance))
                visited.add(Pair(rowIndex, colIndex - 1))
            }
        }

        if (colIndex < width - 1) {
            val right = grid[rowIndex][colIndex + 1]

            if (right == 1 && !visited.contains(Pair(rowIndex, colIndex + 1))) {
                bfsQueue.add(Triple(rowIndex, colIndex + 1, newDistance))
                visited.add(Pair(rowIndex, colIndex + 1))
            }
        }
    }

    if (visited.size != totalOranges) {
        return -1
    }

    return maxDistance
}

fun main() {
    val grid1 = arrayOf(
        intArrayOf(2, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 1, 1),
    )
    print(orangesRotting(grid1))

    val grid2 = arrayOf(
        intArrayOf(0, 2),
    )
    print(orangesRotting(grid2))
}
