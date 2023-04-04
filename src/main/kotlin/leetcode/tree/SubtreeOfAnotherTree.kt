package leetcode.tree

class SubtreeOfAnotherTree {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) return false

        if (sameTree(root, subRoot)) {
            return true
        }

        return isSubtree(root.left, subRoot) or isSubtree(root.right, subRoot)
    }

    private fun sameTree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true

        if (root != null && subRoot != null && root.`val` == subRoot.`val`) {
            return sameTree(root.left, subRoot.left) && sameTree(
                root.right,
                subRoot.right,
            )
        }

        return false
    }
}
