package stanfordAlgorithms.part4.week2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TravelingSalesmanTest {
    private val solution = TravelingSalesman()

    @Test
    fun getDistance() {
        val distance1 = Pair(5.0, 5.0)
        val distance2 = Pair(10.0, 5.0)
        val expected = 5.0

        val distance = solution.calculateDistance(distance1, distance2)

        assertEquals(expected, distance)
    }

//    @Test
//    fun getMinimumCost() {
//        val result = solution.getMinimumCost()
//
//        assertEquals(40.0, result)
//    }
}
