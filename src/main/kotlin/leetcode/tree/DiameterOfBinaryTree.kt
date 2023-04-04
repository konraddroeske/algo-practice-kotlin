package leetcode.tree

class DiameterOfBinaryTree {
    fun getDiameter(root: TreeNode?): Int {
        var result = 0

        fun dfs(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }

            val left = dfs(root.left)
            val right = dfs(root.right)

            result = maxOf(result, left + right)

            return maxOf(left, right) + 1
        }

        dfs(root)

        return result
    }
}