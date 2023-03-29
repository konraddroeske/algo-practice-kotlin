package leetcode.linkedList

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReverseLinkedListTest {

    val solution = ReverseLinkedList()

    @Test
    fun reverseList() {
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

        var result = solution.reverseList(head)

        assertEquals(5, result?.`val`)
        result = result?.next
        assertEquals(4, result?.`val`)
        result = result?.next
        assertEquals(3, result?.`val`)
        result = result?.next
        assertEquals(2, result?.`val`)
        result = result?.next
        assertEquals(1, result?.`val`)
    }
}
