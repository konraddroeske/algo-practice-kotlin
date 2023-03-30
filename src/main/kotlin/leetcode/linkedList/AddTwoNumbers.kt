package leetcode.linkedList

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0, null)
        var carry = 0

        var p1: ListNode? = l1
        var p2: ListNode? = l2
        var prev: ListNode? = dummy

        while (p1 != null || p2 != null || carry > 0) {
            val p1Val = p1?.`val` ?: 0
            val p2Val = p2?.`val` ?: 0

            val sum = (p1Val + p2Val + carry)
            val newVal = sum % 10
            carry = sum / 10

            val newNode = ListNode(newVal, null)
            prev?.next = newNode
            prev = prev?.next

            p1 = p1?.next
            p2 = p2?.next
        }

        return dummy.next
    }
}