package leetcode.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BalancedBinaryTreeTest {
    val solution = BalancedBinaryTree()

    @Test
    fun isBalanced1() {
        val root = TreeNode(
            3,
            TreeNode(9),
            TreeNode(
                20,
                TreeNode(15),
                TreeNode(7),
            ),
        )

        val result = solution.isBalanced(root)

        assertEquals(true, result)
    }

    @Test
    fun isBalanced2() {
        val root = TreeNode(
            1,
            TreeNode(
                2,
                TreeNode(
                    3,
                    TreeNode(4),
                    TreeNode(4),
                ),
                TreeNode(3),
            ),
            TreeNode(
                2,
            ),
        )

        val result = solution.isBalanced(root)

        assertEquals(false, result)
    }

    @Test
    fun isBalanced3() {
        val root = null

        val result = solution.isBalanced(root)

        assertEquals(true, result)
    }
}