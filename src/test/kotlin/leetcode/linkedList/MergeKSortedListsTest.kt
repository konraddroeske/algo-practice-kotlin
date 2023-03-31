package leetcode.linkedList

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MergeKSortedListsTest {
    val solution = MergeKSortedLists()

    @Test
    fun mergeKLists1() {
        val lists: Array<ListNode?> = arrayOf(
            ListNode(1, ListNode(4, ListNode(5, null))),
            ListNode(1, ListNode(3, ListNode(4, null))),
            ListNode(2, ListNode(6, null)),
        )

        var result = solution.mergeKLists(lists)

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
        result = result?.next

        assertEquals(5, result?.`val`)
        result = result?.next

        assertEquals(6, result?.`val`)
        result = result?.next

        assertEquals(null, result?.`val`)
    }
}