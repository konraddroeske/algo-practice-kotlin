package leetcode.linkedList

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class RemoveNthNodeFromEndOfListTest {
    val solution = RemoveNthNodeFromEndOfList()
    @Test
    fun removeNthFromEnd1() {
        val head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode
            (5, null)))))
        var result = solution.removeNthFromEnd(head, 2)

        assertEquals(1, result?.`val`)
        result = result?.next
        assertEquals(2, result?.`val`)
        result = result?.next
        assertEquals(3, result?.`val`)
        result = result?.next
        assertEquals(5, result?.`val`)
        result = result?.next
        assertEquals(null, result?.`val`)

    }

    @Test
    fun removeNthFromEnd2() {
        val head = ListNode(1, null)
        val result = solution.removeNthFromEnd(head, 1)

        assertEquals(null, result?.`val`)
    }

    @Test
    fun removeNthFromEnd3() {
        val head = ListNode(1, ListNode(2, null))
        val result = solution.removeNthFromEnd(head, 1)

        assertEquals(1, result?.`val`)
    }

    @Test
    fun removeNthFromEnd4() {
        val head = ListNode(1, ListNode(2, null))
        val result = solution.removeNthFromEnd(head, 2)

        assertEquals(2, result?.`val`)
    }
}