package leetcode.graphs

class RedundantConnection {
    fun findRedundantConnectionUF(edges: Array<IntArray>): IntArray {
        val parents = IntArray(edges.size + 1) { it }
        val rank = IntArray(edges.size + 1) { 1 }

        for (edge in edges) {
            val node1 = edge[0]
            val node2 = edge[1]

            if (!union(node1, node2, parents, rank)) {
                return edge
            }
        }

        return intArrayOf()
    }

    fun find(node: Int, parents: IntArray): Int {
        var curParent = parents[node]

        while (curParent != parents[curParent]) {
            parents[curParent] = parents[parents[curParent]]
            curParent = parents[curParent]
        }

        return curParent
    }

    fun union(node1: Int, node2: Int, parents: IntArray, rank: IntArray): Boolean {
        val parent1 = find(node1, parents)
        val parent2 = find(node2, parents)

        if (parent1 == parent2) {
            return false
        }

        if (rank[parent1] > rank[parent2]) {
            parents[parent2] = parent1
            rank[parent1] += rank[parent2]
        } else {
            parents[parent1] = parent2
            rank[parent2] += rank[parent1]
        }

        return true
    }
}