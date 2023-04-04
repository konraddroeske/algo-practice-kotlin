package leetcode.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DiameterOfBinaryTreeTest {
    val solution = DiameterOfBinaryTree()

    @Test
    fun diameterOfBinaryTree() {
        val root = TreeNode(
            1,
            TreeNode(2, TreeNode(4), TreeNode(5, TreeNode(6))),
            TreeNode(3, TreeNode(6)),
        )

        val result = solution.getDiameter(root)

        assertEquals(5, result)
    }
}