package leetcode.linkedList
class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head?.next

        while (fast != null) {
            if (slow == fast) return true

            fast = fast.next?.next
            slow = slow?.next
        }

        return false
    }
}