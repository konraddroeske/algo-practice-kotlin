package leetcode.tree

class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return listOf()

        val result = mutableListOf<List<Int>>()

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val qLen = queue.size
            val level = mutableListOf<Int>()

            repeat(qLen) {
                val cur = queue.removeFirst()
                level.add(cur.`val`)

                cur.left?.let { queue.add(it) }
                cur.right?.let { queue.add(it) }
            }

            if (level.isNotEmpty()) {
                result.add(level)
            }
        }

        return result
    }
}

// Time - O(n)
// Space - O(n)