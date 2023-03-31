package leetcode.linkedList

import java.util.PriorityQueue

class MergeKSortedLists {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null

        val queue = PriorityQueue<ListNode> { a, b ->
            a.`val`.compareTo(b.`val`)
        }

        lists.forEach {
            if (it != null) {
                queue.offer(it)
            }
        }

        val dummy = ListNode(Int.MIN_VALUE, null)
        var prev: ListNode? = dummy

        while (queue.isNotEmpty()) {
            val minNode = queue.poll()

            prev?.next = minNode
            prev = prev?.next

            if (minNode?.next != null) {
                queue.offer(minNode.next)
            }
        }

        return dummy.next
    }
}