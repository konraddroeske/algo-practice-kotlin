package leetcode.graph

class PacificAtlantic {
    private fun dfs(
        heights: Array<IntArray>,
        row: Int,
        col: Int,
        visited: MutableSet<Pair<Int, Int>>,
        prevHeight: Int,
    ) {
        // check if in bounds
        if (row !in heights.indices || col !in heights[0].indices) {
            return
        }

        // check if already visited
        if (Pair(row, col) in visited) {
            return
        }

        // check if height if cur height is larger than prev height
        val curHeight = heights[row][col]

        if (curHeight < prevHeight) {
            return
        }

        visited.add(Pair(row, col))

        // dfs for all directions
        dfs(heights, row + 1, col, visited, curHeight)
        dfs(heights, row - 1, col, visited, curHeight)
        dfs(heights, row, col + 1, visited, curHeight)
        dfs(heights, row, col - 1, visited, curHeight)
    }

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val rows = heights.size
        val cols = heights[0].size

        val pacificVisited = mutableSetOf<Pair<Int, Int>>()
        val atlanticVisited = mutableSetOf<Pair<Int, Int>>()

        for (row in heights.indices) {
            dfs(heights, row, 0, pacificVisited, heights[row][0])
            dfs(heights, row, cols - 1, atlanticVisited, heights[row][cols - 1])
        }

        for (col in heights[0].indices) {
            dfs(heights, 0, col, pacificVisited, heights[0][col])
            dfs(heights, rows - 1, col, atlanticVisited, heights[rows - 1][col])
        }

        return (pacificVisited intersect atlanticVisited).map {
            listOf(it.first, it.second)
        }
    }
}

fun main() {
    val heights = arrayOf(
        intArrayOf(1, 2, 2, 3, 5),
        intArrayOf(3, 2, 3, 4, 4),
        intArrayOf(2, 4, 5, 3, 1),
        intArrayOf(6, 7, 1, 4, 5),
        intArrayOf(5, 1, 1, 2, 4),
    )

    val solution = PacificAtlantic()

    val result = solution.pacificAtlantic(heights)

    println(result)
}
