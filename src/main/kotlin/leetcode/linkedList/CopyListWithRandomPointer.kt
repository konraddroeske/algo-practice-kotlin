package leetcode.linkedList

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

class CopyListWithRandomPointer {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null

        val nodeMap = HashMap<Node, Node>()

        // First Pass - Create Nodes & Map
        var pointer = node

        while (pointer != null) {
            val newNode = Node(pointer.`val`)
            nodeMap[pointer] = newNode

            pointer = pointer.next
        }

        // Second Pass - Update properties
        pointer = node

        while (pointer != null) {
            val curNode = nodeMap[pointer]

            curNode?.next = nodeMap[pointer.next]
            curNode?.random = nodeMap[pointer.random]

            pointer = pointer.next
        }

        return nodeMap[node]
    }
}