package leetcode.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumDepthBinaryTreeTest {
    val solution = MaximumDepthBinaryTree()

    @Test
    fun maxDepth() {
        val root = TreeNode(
            3,
            TreeNode(9),
            TreeNode(
                20,
                TreeNode(15),
                TreeNode(7),
            ),
        )

        val result = solution.maxDepth(root)

        assertEquals(3, result)
    }
}