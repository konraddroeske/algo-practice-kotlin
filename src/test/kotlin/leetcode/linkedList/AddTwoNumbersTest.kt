package leetcode.linkedList

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class AddTwoNumbersTest {
    val solution = AddTwoNumbers()

    @Test
    fun addTwoNumbers1() {
        val l1 = ListNode(2, ListNode(4, ListNode(3, null)))
        val l2 = ListNode(5, ListNode(6, ListNode(4, null)))
        var result = solution.addTwoNumbers(l1, l2)

        assertEquals(7, result?.`val`)
        result = result?.next
        assertEquals(0, result?.`val`)
        result = result?.next
        assertEquals(8, result?.`val`)
        result = result?.next
        assertEquals(null, result?.`val`)
    }

    @Test
    fun addTwoNumbers2() {
        val l1 = ListNode(2, ListNode(4, ListNode(5, null)))
        val l2 = ListNode(5, ListNode(6, ListNode(5, null)))
        var result = solution.addTwoNumbers(l1, l2)

        assertEquals(7, result?.`val`)
        result = result?.next
        assertEquals(0, result?.`val`)
        result = result?.next
        assertEquals(1, result?.`val`)
        result = result?.next
        assertEquals(1, result?.`val`)
        result = result?.next
        assertEquals(null, result?.`val`)
    }
}