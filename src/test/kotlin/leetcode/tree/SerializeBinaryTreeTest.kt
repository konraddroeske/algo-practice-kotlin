package leetcode.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SerializeBinaryTreeTest {
    val solution = SerializeBinaryTree()

    @Test
    fun serializeBinaryTree1() {
        val root = TreeNode(
            1,
            TreeNode(2),
            TreeNode(
                3,
                TreeNode(4),
                TreeNode
                (5),
            ),
        )

        val result1 = solution.serialize(root)
        assertEquals("1,2,null,null,3,4,null,null,5,null,null", result1)

        val result2 = solution.deserialize(result1)
        assertEquals(1, result2?.`val`)

        assertEquals(2, result2?.left?.`val`)
        assertEquals(3, result2?.right?.`val`)

        assertEquals(4, result2?.right?.left?.`val`)
        assertEquals(5, result2?.right?.right?.`val`)
    }
}