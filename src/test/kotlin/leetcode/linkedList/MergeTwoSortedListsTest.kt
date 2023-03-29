package leetcode.linkedList

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MergeTwoSortedListsTest {
    val solution = MergeTwoSortedLists()

    @Test
    fun mergeTwoLists() {
        val list1 = ListNode(1, ListNode(2, ListNode(4, null)))
        val list2 = ListNode(1, ListNode(3, ListNode(4, null)))

        var result = solution.mergeTwoLists(list1, list2)

        assertEquals(1, result?.`val`)
        result = result?.next
        assertEquals(1, result?.`val`)
        result = result?.next
        assertEquals(2, result?.`val`)
        result = result?.next
        assertEquals(3, result?.`val`)
        result = result?.next
        assertEquals(4, result?.`val`)
        result = result?.next
        assertEquals(4, result?.`val`)
    }
}