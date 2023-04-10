package leetcode.tree

class SerializeBinaryTree {
    fun serialize(root: TreeNode?): String {
        if (root == null) {
            return "null"
        }

        val rootVal = root.`val`.toString()
        val left = serialize(root.left)
        val right = serialize(root.right)

        return "$rootVal,$left,$right"
    }

    fun deserialize(data: String): TreeNode? {
        val arr = data.split(",").toMutableList()

        fun dfs(): TreeNode? {
            val cur = arr.removeAt(0)

            if (cur == "null") {
                return null
            }

            val newNode = TreeNode(cur.toInt())

            newNode.left = dfs()
            newNode.right = dfs()

            return newNode
        }

        return dfs()
    }
}