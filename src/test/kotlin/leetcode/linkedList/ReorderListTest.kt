package leetcode.linkedList

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ReorderListTest {
    val solution = ReorderList()

    @Test
    fun reorderList1() {
        var head: ListNode? = ListNode(1, ListNode(2, ListNode(3, ListNode(4,
            null))))
        solution.reorderList(head)

        assertEquals(1, head?.`val`)
        head = head?.next
        assertEquals(4, head?.`val`)
        head = head?.next
        assertEquals(2, head?.`val`)
        head = head?.next
        assertEquals(3, head?.`val`)
    }

    @Test
    fun reorderList2() {
        var head: ListNode? = ListNode(1, ListNode(2, ListNode(3, ListNode(4,
            ListNode(5,
        null)))))
        solution.reorderList(head)

        assertEquals(1, head?.`val`)
        head = head?.next
        assertEquals(5, head?.`val`)
        head = head?.next
        assertEquals(2, head?.`val`)
        head = head?.next
        assertEquals(4, head?.`val`)
        head = head?.next
        assertEquals(3, head?.`val`)
    }
}