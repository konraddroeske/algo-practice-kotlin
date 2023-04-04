package leetcode.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LowestCommonAncestorTest {
    val solution = LowestCommonAncestor()

    @Test
    fun lowestCommonAncestor1() {
        val root = TreeNode(
            6,
            TreeNode(
                2,
                TreeNode(0),
                TreeNode(
                    4,
                    TreeNode(3),
                    TreeNode(5),
                ),
            ),
            TreeNode(
                8,
                TreeNode(7),
                TreeNode(9),
            ),
        )

        val p = TreeNode(2)
        val q = TreeNode(8)

        val result = solution.lowestCommonAncestorSolution(root, p, q)

        assertEquals(root, result)
    }

    @Test
    fun lowestCommonAncestor2() {
        val root = TreeNode(
            6,
            TreeNode(
                2,
                TreeNode(0),
                TreeNode(
                    4,
                    TreeNode(3),
                    TreeNode(5),
                ),
            ),
            TreeNode(
                8,
                TreeNode(7),
                TreeNode(9),
            ),
        )

        val p = TreeNode(2)
        val q = TreeNode(4)

        val result = solution.lowestCommonAncestorSolution(root, p, q)

        assertEquals(root.left, result)
    }

    @Test
    fun lowestCommonAncestor3() {
        val root = TreeNode(
            2,
            TreeNode(1),
        )

        val p = TreeNode(2)
        val q = TreeNode(1)

        val result = solution.lowestCommonAncestorSolution(root, p, q)

        assertEquals(root, result)
    }
}