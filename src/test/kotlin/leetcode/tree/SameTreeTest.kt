package leetcode.tree

import SameTree
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SameTreeTest {
    private val solution = SameTree()

    @Test
    fun isSameTree1() {
        val p = TreeNode(
            1,
            left = TreeNode(2),
            right = TreeNode(3),
        )
        val q = TreeNode(
            1,
            left = TreeNode(2),
            right = TreeNode(3),
        )

        val result = solution.isSameTree(p, q)

        assertEquals(true, result)
    }

    @Test
    fun isSameTree2() {
        val p = TreeNode(
            1,
            left = TreeNode(2),
        )
        val q = TreeNode(
            1,
            right = TreeNode(2),
        )

        val result = solution.isSameTree(p, q)

        assertEquals(false, result)
    }

    @Test
    fun isSameTree3() {
        val p = TreeNode(
            1,
            left = TreeNode(2),
            right = TreeNode(1),
        )
        val q = TreeNode(
            1,
            left = TreeNode(1),
            right = TreeNode(2),
        )

        val result = solution.isSameTree(p, q)

        assertEquals(false, result)
    }

    @Test
    fun isSameTree4() {
        val p = null
        val q = null

        val result = solution.isSameTree(p, q)

        assertEquals(true, result)
    }
}
