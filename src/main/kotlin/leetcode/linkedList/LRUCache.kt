package leetcode.linkedList

class LRUCache(capacity: Int) {
    class Node(var key: Int, var value: Int) {
        var next: Node? = null
        var prev: Node? = null
    }

    private val maxCapacity = capacity
    private val map = HashMap<Int, Node>()
    private val head = Node(-1, -1)
    private val tail = Node(-1, -1)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        if (map.containsKey(key)) {
            val node = map[key]

            removeNode(node)
            addNode(node)

            return node!!.value
        }

        return -1
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            removeNode(map[key])
        }

        val newNode = Node(key, value)
        map[key] = newNode
        addNode(newNode)

        if (map.size > maxCapacity) {
            map.remove(tail.prev?.key)
            removeNode(tail.prev)
        }
    }

    private fun addNode(curNode: Node?) {
        val nextTemp = head.next

        head.next = curNode
        curNode?.prev = head

        curNode?.next = nextTemp
        nextTemp?.prev = curNode
    }

    private fun removeNode(curNode: Node?) {
        curNode?.prev?.next = curNode?.next
        curNode?.next?.prev = curNode?.prev
    }
}