package leetcode.linkedList


class RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head?.next == null) return null

        val dummy = ListNode(0, head)
        var slow: ListNode? = dummy
        var fast: ListNode? = dummy
        var counter = 0

        while (fast != null) {
            fast = fast.next

            if (counter > n) {
                slow = slow?.next
            }

            counter += 1
        }

        slow?.next = slow?.next?.next

        return dummy.next
    }
}