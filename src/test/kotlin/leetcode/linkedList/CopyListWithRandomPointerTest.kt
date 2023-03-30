package leetcode.linkedList

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CopyListWithRandomPointerTest {
    val solution = CopyListWithRandomPointer()

    @Test
    fun copyRandomList1() {
        val input0 = Node(7)
        val input1 = Node(13)
        val input2 = Node(11)
        val input3 = Node(10)
        val input4 = Node(1)

        input0.next = input1
        input0.random = null

        input1.next = input2
        input1.random = input0

        input2.next = input3
        input2.random = input4

        input3.next = input4
        input3.random = input2

        input4.next = null
        input4.random = input0

        var result = solution.copyRandomList(input0)
        assertEquals(7, result?.`val`)
        assertEquals(null, result?.random)

        result = result?.next
        assertEquals(13, result?.`val`)
        assertEquals(7, result?.random?.`val`)

        result = result?.next
        assertEquals(11, result?.`val`)
        assertEquals(1, result?.random?.`val`)

        result = result?.next
        assertEquals(10, result?.`val`)
        assertEquals(11, result?.random?.`val`)

        result = result?.next
        assertEquals(1, result?.`val`)
        assertEquals(7, result?.random?.`val`)

        result = result?.next
        assertEquals(null, result?.`val`)
    }
}