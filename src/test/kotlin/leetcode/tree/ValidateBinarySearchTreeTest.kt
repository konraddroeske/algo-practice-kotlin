package leetcode.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidateBinarySearchTreeTest {
    val solution = ValidateBinarySearchTree()

    @Test
    fun isValidBST1() {
        val root = TreeNode(2, TreeNode(1), TreeNode(3))
        val result = solution.isValidBST(root)
        assertEquals(true, result)
    }

    @Test
    fun isValidBST2() {
        val root = TreeNode(
            5,
            TreeNode(1),
            TreeNode(
                4,
                TreeNode(3),
                TreeNode
                (6),
            ),
        )
        val result = solution.isValidBST(root)
        assertEquals(false, result)
    }

    @Test
    fun isValidBST3() {
        val root = TreeNode(
            2,
            TreeNode(2),
            TreeNode(2),
        )
        val result = solution.isValidBST(root)
        assertEquals(false, result)
    }

    @Test
    fun isValidBST4() {
        val root = TreeNode(
            3,
            TreeNode(1, TreeNode(0), TreeNode(2, null, TreeNode(3))),
            TreeNode(5, TreeNode(4), TreeNode(6)),
        )
        val result = solution.isValidBST(root)
        assertEquals(false, result)
    }

    @Test
    fun isValidBST5() {
        val root = TreeNode(2147483647)
        val result = solution.isValidBST(root)
        assertEquals(true, result)
    }

    @Test
    fun isValidBST6() {
        val root = TreeNode(-2147483648, null, TreeNode(2147483647))
        val result = solution.isValidBST(root)
        assertEquals(true, result)
    }
}