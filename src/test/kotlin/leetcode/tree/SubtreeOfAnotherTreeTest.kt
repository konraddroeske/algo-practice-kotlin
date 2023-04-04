package leetcode.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubtreeOfAnotherTreeTest {
    val solution = SubtreeOfAnotherTree()

    @Test
    fun isSubtree1() {
        val root = TreeNode(
            3,
            TreeNode(4, TreeNode(1), TreeNode(2)),
            TreeNode(5),
        )

        val subRoot = TreeNode(4, TreeNode(1), TreeNode(2))

        val result = solution.isSubtree(root, subRoot)

        assertEquals(true, result)
    }

    @Test
    fun isSubtree2() {
        val root = TreeNode(
            3,
            TreeNode(4, TreeNode(1), TreeNode(2, null, TreeNode(0))),
            TreeNode(5),
        )

        val subRoot = TreeNode(4, TreeNode(1), TreeNode(2))

        val result = solution.isSubtree(root, subRoot)

        assertEquals(false, result)
    }
}