package leetcode.linkedList

class ReverseNodesInKGroup {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(Int.MIN_VALUE, head)

        var left: ListNode? = dummy
        var right: ListNode? = dummy

        for (index in 0 until k) {
            right = right?.next
        }

        while (right != null) {
            // reverse window
            var prev = left?.next
            var cur = left?.next?.next
            val end = right.next

            while (cur != end) {
                val tempNext = cur?.next
                cur?.next = prev

                prev = cur
                cur = tempNext
            }

            // connect ends
            left?.next?.next = cur
            left?.next = prev
            right = end

            // shift window
            for (index in 0 until k) {
                left = left?.next

                if (index > 0) {
                    right = right?.next
                }
            }
        }

        return dummy.next
    }
}