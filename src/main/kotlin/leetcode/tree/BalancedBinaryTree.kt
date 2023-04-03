package leetcode.tree

import kotlin.math.abs

class BalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true

        val (result, _) = dfs(root)

        return result
    }

    private fun dfs(root: TreeNode?): Pair<Boolean, Int> {
        if (root == null) return Pair(true, 0)

        val left = dfs(root.left)
        val right = dfs(root.right)

        val balanced = left.first && right.first && abs(left.second - right.second) <= 1
        val height = maxOf(left.second, right.second) + 1

        return Pair(balanced, height)
    }
}