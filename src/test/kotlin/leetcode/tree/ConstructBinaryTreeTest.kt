package leetcode.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ConstructBinaryTreeTest {
    val solution = ConstructBinaryTree()

    @Test
    fun buildTree1() {
        val preorder = intArrayOf(3, 9, 20, 15, 7)
        val inorder = intArrayOf(9, 3, 15, 20, 7)

        val result = solution.buildTree(preorder, inorder)

        if (result != null) {
            val stack = ArrayDeque<TreeNode>()
            stack.add(result)

            while (stack.isNotEmpty()) {
                val cur = stack.removeFirst()
                println("cur val: ${cur.`val`}")

                cur.left?.let { stack.add(it) }
                cur.right?.let { stack.add(it) }
            }
        }
    }

    @Test
    fun buildTree2() {
        val preorder = intArrayOf(-1)
        val inorder = intArrayOf(-1)

        val result = solution.buildTree(preorder, inorder)

        if (result != null) {
            val stack = ArrayDeque<TreeNode>()
            stack.add(result)

            while (stack.isNotEmpty()) {
                val cur = stack.removeFirst()
                println("cur val: ${cur.`val`}")

                cur.left?.let { stack.add(it) }
                cur.right?.let { stack.add(it) }
            }
        }
    }
}