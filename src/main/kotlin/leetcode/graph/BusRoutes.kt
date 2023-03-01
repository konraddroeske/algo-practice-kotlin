package leetcode.graph

import java.util.*

class BusRoutes {
    fun numBusesToDestination(
        routes: Array<IntArray>,
        source: Int,
        target: Int,
    ): Int {
        if (source == target) return 0

        val stopToRoutes = mutableMapOf<Int, MutableList<Int>>()

        routes.forEachIndexed { routeIndex, route ->
            route.forEach { stop ->
                stopToRoutes.getOrPut(stop) { mutableListOf() } += routeIndex
            }
        }

        val visitedStops = mutableSetOf<Int>()
        val visitedRoutes = mutableSetOf<Int>()
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(source, 0))

        while (queue.isNotEmpty()) {
            val (curStop, busCount) = queue.pop()

            if (curStop == target) return busCount
            if (curStop in visitedStops) continue

            visitedStops.add(curStop)

            val intersectingRoutes = stopToRoutes.getOrPut(curStop) { mutableListOf() }

            for (routeIndex in intersectingRoutes) {
                if (routeIndex in visitedRoutes) continue

                val routeStops = routes[routeIndex]

                for (routeStop in routeStops) {
                    if (routeStop in visitedStops) continue

                    queue.add(Pair(routeStop, busCount + 1))
                    visitedRoutes.add(routeIndex)
                }
            }
        }

        return -1
    }
}

fun main() {
    val busRoutes = BusRoutes()

    val routes1 = arrayOf(
        intArrayOf(1, 2, 7),
        intArrayOf(3, 6, 7),
    )
    val source1 = 1
    val target1 = 6

    val result1 = busRoutes.numBusesToDestination(routes1, source1, target1)
    println("result1: $result1")

    val routes2 = arrayOf(
        intArrayOf(7, 12),
        intArrayOf(4, 5, 15),
        intArrayOf(6),
        intArrayOf(15, 19),
        intArrayOf(9, 12, 13),
    )
    val source2 = 15
    val target2 = 12

    val result2 = busRoutes.numBusesToDestination(routes2, source2, target2)
    println("result2: $result2")

    val source3 = 37
    val target3 = 28

    val routes3 = arrayOf(
        intArrayOf(1, 9, 12, 20, 23, 24, 35, 38),
        intArrayOf(10, 21, 24, 31, 32, 34, 37, 38, 43),
        intArrayOf(
            10,
            19,
            28,
            37,
        ),
        intArrayOf(8),
        intArrayOf(14, 19),
        intArrayOf(
            11,
            17,
            23,
            31,
            41,
            43,
            44,
        ),
        intArrayOf(
            21,
            26,
            29,
            33,
        ),
        intArrayOf(
            5,
            11,
            33,
            41,
        ),
        intArrayOf(
            4,
            5,
            8,
            9,
            24,
            44,
        ),
    )

    val result3 = busRoutes.numBusesToDestination(routes3, source3, target3)
    println("result3: $result3")

    val source4 = 7
    val target4 = 47

    val routes4 = arrayOf(
        intArrayOf(25, 33), intArrayOf(3, 5, 13, 22, 23, 29, 37, 45, 49),
        intArrayOf(
            15,
            16,
            41,
            47,
        ),
        intArrayOf(5, 11, 17, 23, 33),
        intArrayOf(
            10,
            11,
            12,
            29,
            30,
            39,
            45,
        ),
        intArrayOf(2, 5, 23, 24, 33),
        intArrayOf(
            1, 2, 9,
            19, 20, 21,
            23, 32, 34, 44,
        ),
        intArrayOf(7, 18, 23, 24),
        intArrayOf(
            1,
            2,
            7,
            27,
            36,
            44,
        ),
        intArrayOf(7, 14, 33),
    )

    val result4 = busRoutes.numBusesToDestination(routes4, source4, target4)
    println("result4: $result4")
}
