package leetcode.linkedList

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LRUCacheTest {

    @Test
    fun test1() {
        val capacity = 2
        val cache = LRUCache(capacity)

        cache.put(1, 1)
        cache.put(2, 2)
        val get1 = cache.get(1)

        assertEquals(1, get1)

        cache.put(3, 3)
        val get2 = cache.get(2)

        assertEquals(-1, get2)

        cache.put(4, 4)
        val get3 = cache.get(1)

        assertEquals(-1, get3)

        val get4 = cache.get(3)
        assertEquals(3, get4)

        val get5 = cache.get(4)
        assertEquals(4, get5)
    }
}