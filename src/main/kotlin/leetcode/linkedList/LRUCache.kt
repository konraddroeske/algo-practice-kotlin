package leetcode.linkedList

class LRUNode(var key: Int, var value: Int) {
    var next: LRUNode? = null
    var prev: LRUNode? = null
}

class LRUCache(capacity: Int) {
    private val maxCapacity = capacity
    private val cache = HashMap<Int, LRUNode>()
    private val head = LRUNode(-1, -1)
    private val tail = LRUNode(-1, -1)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = cache[key] ?: return -1
        addToHead(node)

        return node.value
    }

    fun put(key: Int, value: Int) {
        val curNode = cache[key]

        if (curNode != null) {
            curNode.value = value
            addToHead(curNode)
            return
        }

        val newNode = LRUNode(key, value)
        cache[key] = newNode
        addToHead(newNode)

        if (cache.size > maxCapacity) {
            cache.remove(tail.prev?.key)
            removeTail()
        }
    }

    private fun addToHead(newNode: LRUNode) {
        removeFromList(newNode.key)

        val tempNode = head.next

        head.next = newNode
        newNode.prev = head

        newNode.next = tempNode
        tempNode?.prev = newNode
    }

    private fun removeTail() {
        val prevTemp = tail.prev?.prev

        prevTemp?.next = tail
        tail.prev = prevTemp
    }

    private fun removeFromList(key: Int) {
        val curNode = cache[key]

        val prevTemp = curNode?.prev
        val nextTemp = curNode?.next

        prevTemp?.next = nextTemp
        nextTemp?.prev = prevTemp
    }
}