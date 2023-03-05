class SameTree {
    fun isSameTreeRecursive(p: TreeNode?, q: TreeNode?): Boolean {
        return when {
            p == null && q == null -> true
            p?.`val` != q?.`val` -> false
            else -> isSameTreeRecursive(p?.left, q?.left) &&
                isSameTreeRecursive(p?.right, q?.right)
        }
    }
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        val stack = ArrayDeque(listOf(Pair(p, q)))

        while (stack.isNotEmpty()) {
            val (pNode, qNode) = stack.removeFirst()

            val curResult = isSame(pNode, qNode)
            val leftResult = isSame(pNode?.left, qNode?.left)
            val rightResult = isSame(pNode?.right, qNode?.right)

            if (!curResult || !leftResult || !rightResult) return false

            if (pNode?.left != null && qNode?.left != null) {
                stack.add(Pair(pNode.left!!, qNode.left!!))
            }

            if (pNode?.right != null && qNode?.right != null) {
                stack.add(Pair(pNode.right!!, qNode.right!!))
            }
        }

        return true
    }

    private fun isSame(pNode: TreeNode?, qNode: TreeNode?): Boolean {
        if (pNode == null && qNode == null) return true
        if (pNode == null || qNode == null) return false

        return pNode.`val` == qNode.`val`
    }
}
