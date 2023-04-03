package leetcode.tree

import SymmetricTree
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SymmetricTreeTest {
    private val solution = SymmetricTree()

    @Test
    fun isSymmetric1() {
        val input = TreeNode(
            1,
            left = TreeNode(
                2,
                left = TreeNode(3),
                right = TreeNode
                (4),
            ),
            right = TreeNode(
                2,
                left = TreeNode(4),
                right = TreeNode
                (3),
            ),
        )
        val result = solution.isSymmetric(input)
        assertEquals(true, result)
    }

    @Test
    fun isSymmetric2() {
        val input = TreeNode(
            1,
            left = TreeNode(
                2,
                right = TreeNode
                (4),
            ),
            right = TreeNode(
                2,
                right = TreeNode
                (4),
            ),
        )
        val result = solution.isSymmetric(input)
        assertEquals(false, result)
    }
}
