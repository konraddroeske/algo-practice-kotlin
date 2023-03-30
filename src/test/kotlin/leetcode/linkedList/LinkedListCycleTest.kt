package leetcode.linkedList

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LinkedListCycleTest {
    val solution = LinkedListCycle()

    @Test
    fun hasCycle1() {
        val node1 = ListNode(3, null)
        val node2 = ListNode(2, null)
        val node3 = ListNode(0, null)
        val node4 = ListNode(-4, null)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node2

        val result = solution.hasCycle(node1)

        assertEquals(true, result)
    }

    @Test
    fun hasCycle2() {
        val node1 = ListNode(3, null)
        val node2 = ListNode(2, null)

        node1.next = node2
        node2.next = node1

        val result = solution.hasCycle(node1)

        assertEquals(true, result)
    }

    @Test
    fun hasCycle3() {
        val node1 = ListNode(3, null)

        val result = solution.hasCycle(node1)

        assertEquals(false, result)
    }
}