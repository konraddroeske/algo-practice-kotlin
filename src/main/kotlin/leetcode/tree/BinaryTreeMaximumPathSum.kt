package leetcode.tree
class BinaryTreeMaximumPathSum {
    private var maxSum = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        dfs(root)

        return maxSum
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val cur = root.`val`

        val leftMax = dfs(root.left)
        val rightMax = dfs(root.right)

        val curMax = intArrayOf(
            cur,
            leftMax + cur,
            rightMax + cur,
        ).max()

        val total = cur + leftMax + rightMax

        maxSum = maxOf(maxSum, curMax, total)

        return curMax
    }
}