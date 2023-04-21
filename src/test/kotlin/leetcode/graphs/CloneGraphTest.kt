package leetcode.graphs

import org.junit.jupiter.api.Test

class CloneGraphTest {
    val solution = CloneGraph()

    @Test
    fun cloneGraph() {
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)
        val node4 = Node(4)

        node1.neighbors = arrayListOf(node2, node4)
        node2.neighbors = arrayListOf(node1, node3)
        node3.neighbors = arrayListOf(node2, node4)
        node4.neighbors = arrayListOf(node1, node3)

        val clone = solution.getCloneGraph(node1)

        println("clone: ${clone?.`val`}")

        clone?.neighbors?.forEach {
            println("neighbour: ${it?.`val`}")
        }
    }
}