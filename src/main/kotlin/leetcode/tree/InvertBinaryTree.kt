package leetcode.tree

class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        val temp = invertTree(root.right)
        root.right = invertTree(root.left)
        root.left = temp

        return root
    }
}