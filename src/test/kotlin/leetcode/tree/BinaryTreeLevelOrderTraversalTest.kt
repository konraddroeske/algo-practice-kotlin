package leetcode.tree

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class BinaryTreeLevelOrderTraversalTest {
    val solution = BinaryTreeLevelOrderTraversal()

    @Test
    fun levelOrder1() {
        val root = TreeNode(
            3,
            TreeNode(9),
            TreeNode(
                20,
                TreeNode(15),
                TreeNode(7),
            ),
        )

        val result = solution.levelOrder(root)

        assertContentEquals(result[0], listOf(3))
        assertContentEquals(result[1], listOf(9, 20))
        assertContentEquals(result[2], listOf(15, 7))
    }

    @Test
    fun levelOrder2() {
        val root = TreeNode(1)

        val result = solution.levelOrder(root)

        assertContentEquals(result[0], listOf(1))
    }

    @Test
    fun levelOrder3() {
        val root = null

        val result = solution.levelOrder(root)

        assertContentEquals(result, listOf())
    }
}