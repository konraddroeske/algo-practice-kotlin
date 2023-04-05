package leetcode.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class KthSmallestElementInABSTTest {
    val solution = KthSmallestElementInABST()

    @Test
    fun kthSmallest1() {
        val root = TreeNode(3, TreeNode(1, null, TreeNode(2)), TreeNode(4))
        val result = solution.kthSmallest(root, 1)

        assertEquals(1, result)
    }

    @Test
    fun kthSmallest2() {
        val root = TreeNode(
            5,
            TreeNode(
                3,
                TreeNode(2, TreeNode(1)),
                TreeNode(4),
            ),
            TreeNode(6),
        )
        val result = solution.kthSmallest(root, 3)

        assertEquals(3, result)
    }
}