package leetcode.tree

class CountGoodNodesInBinaryTree {
    fun goodNodes(root: TreeNode?): Int {
        return dfs(root, Int.MIN_VALUE)
    }

    fun dfs(root: TreeNode?, curMax: Int): Int {
        if (root == null) return 0

        val newMax = maxOf(curMax, root.`val`)
        val count = if (root.`val` >= newMax) { 1 } else { 0 }

        return count + dfs(root.left, newMax) + dfs(root.right, newMax)
    }
}