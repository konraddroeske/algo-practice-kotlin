package leetcode.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BinaryTreeMaximumPathSumTest {
    val solution = BinaryTreeMaximumPathSum()

    @Test
    fun maxPathSum1() {
        val root = TreeNode(1, TreeNode(2), TreeNode(3))
        val result = solution.maxPathSum(root)

        assertEquals(6, result)
    }

    @Test
    fun maxPathSum2() {
        val root = TreeNode(
            -10,
            TreeNode(9),
            TreeNode(
                20,
                TreeNode(15),
                TreeNode(7),
            ),
        )
        val result = solution.maxPathSum(root)

        assertEquals(42, result)
    }

    @Test
    fun maxPathSum3() {
        val root = TreeNode(-3)
        val result = solution.maxPathSum(root)

        assertEquals(-3, result)
    }

    @Test
    fun maxPathSum4() {
        val root = TreeNode(
            5,
            TreeNode(
                4,
                TreeNode(
                    11,
                    TreeNode(7),
                    TreeNode(2),
                ),
            ),
            TreeNode(
                8,
                TreeNode(13),
                TreeNode(
                    4,
                    null,
                    TreeNode(1),
                ),
            ),

        )
        val result = solution.maxPathSum(root)

        assertEquals(48, result)
    }
}