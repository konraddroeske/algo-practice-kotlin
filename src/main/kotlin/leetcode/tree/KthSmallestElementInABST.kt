package leetcode.tree
class KthSmallestElementInABST {
    private var counter = 0
    var result = 0
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        dfs(root, k)

        return result
    }

    private fun dfs(root: TreeNode?, k: Int) {
        if (root == null) {
            return
        }

        dfs(root.left, k)

        counter += 1

        if (counter == k) {
            result = root.`val`
            return
        }

        dfs(root.right, k)
    }
}