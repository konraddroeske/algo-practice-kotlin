package leetcode.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InvertBinaryTreeTest {
    val solution = InvertBinaryTree()

    @Test
    fun invertTree() {
        val root = TreeNode(
            4,
            TreeNode(2, TreeNode(1), TreeNode(3)),
            TreeNode(7, TreeNode(6), TreeNode(9)),
        )

        // level 0
        val result = solution.invertTree(root)
        assertEquals(4, result?.`val`)

        // level 1
        val left = result?.left
        assertEquals(7, left?.`val`)

        val right = result?.right
        assertEquals(2, right?.`val`)
    }
}