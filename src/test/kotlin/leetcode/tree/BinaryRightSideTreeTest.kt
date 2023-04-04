package leetcode.tree

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class BinaryRightSideTreeTest {
    val solution = BinaryRightSideTree()

    @Test
    fun rightSideView1() {
        val root = TreeNode(
            1,
            TreeNode(2, TreeNode(5)),
            TreeNode(
                3,
                null,
                TreeNode(4),
            ),
        )

        val result = solution.rightSideViewDFS(root)

        assertContentEquals(listOf(1, 3, 4), result)
    }

    @Test
    fun rightSideView2() {
        val root = TreeNode(
            1,
            null,
            TreeNode(
                3,
            ),
        )

        val result = solution.rightSideViewDFS(root)

        assertContentEquals(listOf(1, 3), result)
    }

    @Test
    fun rightSideView3() {
        val root = null

        val result = solution.rightSideViewDFS(root)

        assertContentEquals(listOf(), result)
    }

    @Test
    fun rightSideView4() {
        val root = TreeNode(1, TreeNode(2))

        val result = solution.rightSideViewDFS(root)

        assertContentEquals(listOf(1, 2), result)
    }
}