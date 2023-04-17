package leetcode.heap

import java.util.PriorityQueue

class KClosestPointsToOrigin {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val heap = PriorityQueue(
            points.map {
                Point(it[0], it[1])
            },
        )

        return Array(k) {
            val point = heap.poll()
            intArrayOf(point.x, point.y)
        }
    }

    data class Point(val x: Int, val y: Int) : Comparable<Point> {
        override fun compareTo(other: Point): Int {
            val first = getDistance(x, y)
            val second = getDistance(other.x, other.y)
            return first.compareTo(second)
        }

        private fun getDistance(x: Int, y: Int): Double {
            return Math.sqrt(
                Math.pow(x.toDouble(), 2.0) + Math.pow(y.toDouble(), 2.0),
            )
        }
    }
}