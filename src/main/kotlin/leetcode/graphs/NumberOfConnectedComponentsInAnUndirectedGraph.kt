package leetcode.graphs

// Time - O(edges * union find)
// Time - O(edges * inverse ackermann(n))
class NumberOfConnectedComponentsInAnUndirectedGraph {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val parents = IntArray(n) { it }
        val rank = IntArray(n) { 1 }
        var totalComponents = n

        for (edge in edges) {
            totalComponents -= union(edge[0], edge[1], parents, rank)
        }

        return totalComponents
    }

    private fun find(node: Int, parents: IntArray): Int {
        var parent = parents[node]

        while (parent != parents[parent]) {
            parents[parent] = parents[parents[parent]]
            parent = parents[parent]
        }

        return parent
    }

    private fun union(
        node1: Int,
        node2: Int,
        parents: IntArray,
        rank: IntArray,
    ): Int {
        val parent1 = find(node1, parents)
        val parent2 = find(node2, parents)

        if (parent1 == parent2) {
            return 0
        }

        if (rank[parent1] > rank[parent2]) {
            parents[parent2] = parent1
            rank[parent1] += rank[parent2]
        } else {
            parents[parent1] = parent2
            rank[parent2] += rank[parent1]
        }

        return 1
    }
}