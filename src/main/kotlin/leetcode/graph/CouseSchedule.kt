package leetcode.graph

import java.util.*

class CourseScheduleKahnAlgorithm {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        if (numCourses <= 0) return IntArray(0)

        // build adjacency list
        val edges = Array(numCourses) { mutableListOf<Int>() }
        val inDegrees = IntArray(numCourses)

        prerequisites.forEach { (head, tail) ->
            edges[tail].add(head)
            inDegrees[head] += 1
        }

        // check if a vertex without an inDegree exists
        val verticesWithoutInDegree = mutableListOf<Int>()

        for ((index, value) in inDegrees.withIndex()) {
            if (value == 0) {
                verticesWithoutInDegree.add(index)
            }
        }

        if (verticesWithoutInDegree.isEmpty()) return IntArray(0)

        val queue = LinkedList(verticesWithoutInDegree)
        val result = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val curNode = queue.pop()

            for (neighbour in edges[curNode]) {
                inDegrees[neighbour] -= 1

                if (inDegrees[neighbour] == 0) {
                    queue.add(neighbour)
                }
            }

            result.add(curNode)
        }

        return if (result.size == numCourses) result.toIntArray() else
            IntArray(0)
    }
}

fun main() {
    val numCourses1 = 2
    val prerequisites1 = arrayOf(intArrayOf(1, 0))

    val numCourses2 = 4
    val prerequisites2 = arrayOf(
        intArrayOf(1, 0), intArrayOf(2, 0),
        intArrayOf(3, 1), intArrayOf(3, 2)
    )

    val numCourses3 = 3
    val prerequisites3 = arrayOf(
        intArrayOf(2, 0), intArrayOf(2, 1),
    )

    val solution = CourseScheduleKahnAlgorithm()

    val arr1 = solution.findOrder(numCourses1, prerequisites1)
    println(arr1.contentToString())

    val arr2 = solution.findOrder(numCourses2, prerequisites2)
    println(arr2.contentToString())


    val arr3 = solution.findOrder(numCourses3, prerequisites3)
    println(arr3.contentToString())
}