package leetcode.linkedList
class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null && list2 == null) return null
        if (list1 == null) return list2
        if (list2 == null) return list1

        val dummy = ListNode(0, null)
        var cur = dummy
        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            if (l1.`val` <= l2.`val`) {
                cur.next = l1
                l1 = l1.next
            } else {
                cur.next = l2
                l2 = l2.next
            }

            cur = cur.next!!
        }

        if (l1 != null) {
            cur.next = l1
        }

        if (l2 != null) {
            cur.next = l2
        }

        return dummy.next
    }
}