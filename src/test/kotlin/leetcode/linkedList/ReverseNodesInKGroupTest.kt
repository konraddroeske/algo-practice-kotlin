package leetcode.linkedList

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReverseNodesInKGroupTest {

    val solution = ReverseNodesInKGroup()

    @Test
    fun reverseKGroup1() {
        val head = ListNode(
            1,
            ListNode(
                2,
                ListNode(
                    3,
                    ListNode(
                        4,
                        ListNode
                        (5, null),
                    ),
                ),
            ),
        )

        var result = solution.reverseKGroup(head, 2)
        assertEquals(2, result?.`val`)

        result = result?.next
        assertEquals(1, result?.`val`)

        result = result?.next
        assertEquals(4, result?.`val`)

        result = result?.next
        assertEquals(3, result?.`val`)

        result = result?.next
        assertEquals(5, result?.`val`)

        result = result?.next
        assertEquals(null, result)
    }

    @Test
    fun reverseKGroup2() {
        val head = ListNode(
            1,
            ListNode(
                2,
                null,
            ),
        )

        var result = solution.reverseKGroup(head, 2)
        assertEquals(2, result?.`val`)

        result = result?.next
        assertEquals(1, result?.`val`)

        result = result?.next
        assertEquals(null, result)
    }
}