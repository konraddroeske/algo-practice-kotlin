package leetcode.tree

class ValidateBinarySearchTree {
    fun isValidBST(
        root: TreeNode?,
        minVal: Long = Long.MIN_VALUE,
        maxVal: Long = Long.MAX_VALUE,
    ): Boolean {
        if (root == null) return true

        val curVal = root.`val`.toLong()

        if (curVal <= minVal || curVal >= maxVal) {
            return false
        }

        return isValidBST(root.left, minVal, curVal) &&
            isValidBST(root.right, curVal, maxVal)
    }
}