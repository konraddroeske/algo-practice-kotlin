
class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        return isSameTree(root?.left, root?.right)
    }

    private fun isSameTree(left: TreeNode?, right: TreeNode?): Boolean {
        return when {
            left == null && right == null -> true
            left?.`val` != right?.`val` -> false
            else -> isSameTree(left?.left, right?.right) &&
                isSameTree(left?.right, right?.left)
        }
    }
}
