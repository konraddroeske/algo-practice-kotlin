package leetcode.tree
class BinaryRightSideTree {
    fun rightSideViewBFS(root: TreeNode?): List<Int> {
        if (root == null) return listOf()

        val result = mutableListOf<Int>()

        val queue = ArrayDeque<TreeNode>()
        root.let { queue.add(it) }

        while (queue.isNotEmpty()) {
            val levelLength = queue.size

            for (index in 0 until levelLength) {
                val cur = queue.removeFirst()

                if (index == levelLength - 1) {
                    result.add(cur.`val`)
                }

                cur.left?.let { queue.add(it) }
                cur.right?.let { queue.add(it) }
            }
        }

        return result
    }

    fun rightSideViewDFS(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val level = 0

        dfs(root, level, result)

        return result
    }

    fun dfs(root: TreeNode?, level: Int, result: MutableList<Int>) {
        if (root == null) {
            return
        }

        if (level == result.size) {
            result.add(root.`val`)
        }

        dfs(root.right, level + 1, result)
        dfs(root.left, level + 1, result)
    }
}