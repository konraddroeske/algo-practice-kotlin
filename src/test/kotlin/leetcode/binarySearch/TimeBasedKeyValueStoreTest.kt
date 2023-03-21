package leetcode.binarySearch

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TimeBasedKeyValueStoreTest {

    @Test
    fun timeMap1() {
        val timeMap = TimeBasedKeyValueStore()

        timeMap.set("foo", "bar", 1)

        val get1 = timeMap.get("foo", 1) // return "bar"
        assertEquals("bar", get1)

        val get2 = timeMap.get("foo", 3) // return "bar", since there is no
        assertEquals("bar", get2)

        // value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4) // store the key "foo" and value "bar2" along with timestamp = 4.

        val get3 = timeMap.get("foo", 4); // return "bar2"
        assertEquals("bar2", get3)
        val get4 = timeMap.get("foo", 5); // return "bar2"
        assertEquals("bar2", get4)
    }

    @Test
    fun timeMap2() {
        val timeMap = TimeBasedKeyValueStore()

        timeMap.set("love", "high", 10)
        timeMap.set("love", "low", 20)

        val get1 = timeMap.get("love", 5)
        assertEquals("", get1)

        val get2 = timeMap.get("love", 10)
        assertEquals("high", get2)

        val get3 = timeMap.get("love", 15)
        assertEquals("high", get3)

        val get4 = timeMap.get("love", 20)
        assertEquals("low", get4)

        val get5 = timeMap.get("love", 25)
        assertEquals("low", get5)
    }
}
