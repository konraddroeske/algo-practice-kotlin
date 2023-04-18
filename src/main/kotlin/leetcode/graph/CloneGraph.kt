package leetcode.graph

class CloneGraph {
    private val cloneMap = HashMap<Int, Node>()
    fun getCloneGraph(node: Node?): Node? {
        if (node == null) return null

        return dfs(node)
    }

    fun dfs(origNode: Node): Node {
        if (cloneMap.contains(origNode.`val`)) {
            return cloneMap.getValue(origNode.`val`)
        }

        val cloneNode = Node(origNode.`val`)
        cloneMap[cloneNode.`val`] = cloneNode

        for (neighbour in origNode.neighbors) {
            if (neighbour == null) {
                continue
            }

            cloneNode.neighbors.add(dfs(neighbour))
        }

        return cloneNode
    }
}