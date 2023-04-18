package leetcode.heap

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindMedianFromDataStreamTest {

    @Test
    fun test1() {
        val medianFinder = FindMedianFromDataStream()

        medianFinder.addNum(1)
        medianFinder.addNum(2)

        val median1 = medianFinder.findMedian()
        assertEquals(1.5, median1)

        medianFinder.addNum(3)
        medianFinder.findMedian()

        val median2 = medianFinder.findMedian()
        assertEquals(2.0, median2)
    }

    @Test
    fun test2() {
        val medianFinder = FindMedianFromDataStream()

        medianFinder.addNum(6)

        val median1 = medianFinder.findMedian()
        assertEquals(median1, 6.0)

        medianFinder.addNum(10)

        val median2 = medianFinder.findMedian()
        assertEquals(median2, 8.0)

        medianFinder.addNum(2)

        val median3 = medianFinder.findMedian()
        assertEquals(median3, 6.0)

        medianFinder.addNum(6)

        val median4 = medianFinder.findMedian()
        assertEquals(median4, 6.0)

        medianFinder.addNum(5)

        val median5 = medianFinder.findMedian()
        assertEquals(median5, 6.0)

        medianFinder.addNum(0)

        val median6 = medianFinder.findMedian()
        assertEquals(median6, 5.5)

        medianFinder.addNum(6)

        val median7 = medianFinder.findMedian()
        assertEquals(median7, 6.0)

        medianFinder.addNum(3)

        val median8 = medianFinder.findMedian()
        assertEquals(median8, 5.5)

        medianFinder.addNum(1)

        val median9 = medianFinder.findMedian()
        assertEquals(median9, 5.0)

        medianFinder.addNum(0)

        val median10 = medianFinder.findMedian()
        assertEquals(median10, 4.0)

        medianFinder.addNum(0)

        val median11 = medianFinder.findMedian()
        assertEquals(median11, 3.0)
    }
}