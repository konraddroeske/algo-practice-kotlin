package leetcode.linkedList

class ReorderList {
    fun reorderList(head: ListNode?) {
        if (head == null) return
        if (head.next == null) return

        val dummy = ListNode(0, head)
        var slow: ListNode? = dummy
        var fast: ListNode? = dummy

        // Part 1 - Find Middle & Reverse from Middle to End
        while (fast != null) {
            fast = fast.next?.next
            slow = slow?.next
        }

        var right = slow
        slow = slow?.next
        right?.next = null

        while (slow != null) {
            val slowTemp = slow.next
            slow.next = right
            right = slow
            slow = slowTemp
        }

        // Part 2 - Traverse from both ends and assign next values
        var left = dummy.next

        while (left != null || right != null) {
            val leftTemp = left?.next
            left?.next = right
            left = leftTemp

            val rightTemp = right?.next
            right?.next = left
            right = rightTemp
        }
    }
}