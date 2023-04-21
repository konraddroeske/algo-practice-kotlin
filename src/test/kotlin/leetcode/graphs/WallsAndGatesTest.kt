package leetcode.graphs

import org.junit.jupiter.api.Test

class WallsAndGatesTest {
    val solution = WallsAndGates()

    @Test
    fun wallsAndGates1() {
        val rooms = arrayOf(
            intArrayOf(2147483647, -1, 0, 2147483647),
            intArrayOf(2147483647, 2147483647, 2147483647, -1),
            intArrayOf(2147483647, -1, 2147483647, -1),
            intArrayOf(0, -1, 2147483647, 2147483647),
        )
        solution.updateWallsAndGates(rooms)

        for (row in rooms) {
            println(row.contentToString())
        }
    }

    @Test
    fun wallsAndGates2() {
        val rooms = arrayOf(
            intArrayOf(-1),
        )
        solution.updateWallsAndGates(rooms)

        for (row in rooms) {
            println(row.contentToString())
        }
    }
}