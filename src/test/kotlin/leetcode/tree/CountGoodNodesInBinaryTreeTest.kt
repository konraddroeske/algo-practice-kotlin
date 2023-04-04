package leetcode.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountGoodNodesInBinaryTreeTest {
    val solution = CountGoodNodesInBinaryTree()

    @Test
    fun goodNodes1() {
        val root = TreeNode(
            3,
            TreeNode(1, TreeNode(3)),
            TreeNode(
                4,
                TreeNode(1),
                TreeNode(5),
            ),
        )
        val result = solution.goodNodes(root)
        assertEquals(4, result)
    }

    @Test
    fun goodNodes2() {
        val root = TreeNode(
            3,
            TreeNode(3, TreeNode(4), TreeNode(2)),
        )
        val result = solution.goodNodes(root)
        assertEquals(3, result)
    }

    @Test
    fun goodNodes3() {
        val root = TreeNode(1)
        val result = solution.goodNodes(root)
        assertEquals(1, result)
    }
}