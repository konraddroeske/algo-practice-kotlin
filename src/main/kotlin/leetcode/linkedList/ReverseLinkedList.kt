package leetcode.linkedList

class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        var cur = head
        var prev: ListNode? = null

        while (cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }

        return prev
    }
}
