package leetcode.tree

class ConstructBinaryTree {
    private val inorderHash = HashMap<Int, Int>()
    private var rootIndex = 0
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        // with hashmap
        inorder.forEachIndexed { index, i ->
            inorderHash[i] = index
        }

        return dfs(preorder, 0, preorder.size - 1)
    }

    fun dfs(
        preorder: IntArray,
        inorderLeft: Int,
        inorderRight: Int,
    ): TreeNode? {
        if (inorderLeft > inorderRight) {
            return null
        }

        val rootVal = preorder[rootIndex]
        rootIndex += 1

        val root = TreeNode(rootVal)
        val mid = inorderHash[rootVal]!!

        root.left = dfs(preorder, inorderLeft, mid - 1)
        root.right = dfs(preorder, mid + 1, inorderRight)

        return root
    }
}