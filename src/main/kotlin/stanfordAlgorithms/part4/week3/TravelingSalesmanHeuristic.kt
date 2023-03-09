
import java.io.File
import java.nio.file.Paths
import kotlin.math.pow
import kotlin.math.sqrt

fun importDataset(filename: String): MutableList<Triple<Int, Double, Double>> {
    val dir = Paths.get(
        "src",
        "main",
        "kotlin",
        "stanfordAlgorithms",
        "part4",
        "week3",
    )
        .toAbsolutePath()
        .toString()

    val pathname = "$dir/$filename"

    val lineList = mutableListOf<Triple<Int, Double, Double>>()

    File(pathname).useLines { lines ->
        lines.forEachIndexed { index, it ->
            if (index > 0) {
                val result = it.split(" ")
                lineList.add(
                    Triple(
                        result[0].toInt(),
                        result[1].toDouble(),
                        result[2].toDouble(),
                    ),
                )
            }
        }
    }

    return lineList
}

class TravelingSalesmanHeuristic {
    fun calculateDistance(
        location1: Triple<Int, Double, Double>,
        location2: Triple<Int, Double, Double>,
    ): Double {
        val (_, x, y) = location1
        val (_, z, w) = location2

        return sqrt((x - z).pow(2) + (y - w).pow(2))
    }

    fun getMinimumCost(): Double {
        val locations = importDataset("tspInputHeuristic.txt")

        var curLocation = locations.first()
        val locationsSet = importDataset("tspInputHeuristic.txt").toMutableSet()

        var totalDistance = 0.0

        while (locationsSet.size > 0) {
            locationsSet.remove(curLocation)

            var minDistance = Double.MAX_VALUE
            var nextLocation: Triple<Int, Double, Double>? = null

            // get shortest distance from cur location
            for (location in locationsSet) {
                val curDistance = calculateDistance(curLocation, location)

                if (curDistance < minDistance) {
                    minDistance = curDistance
                    nextLocation = location
                } else if (curDistance == minDistance && nextLocation != null) {
                    nextLocation = if (nextLocation.first < location.first) {
                        nextLocation
                    } else {
                        location
                    }
                }
            }

            // update total distance, cur location
            if (nextLocation != null) {
                totalDistance += minDistance
                curLocation = nextLocation
            }
        }

        // add final hop to start
        val finalDistance = calculateDistance(
            curLocation,
            locations.first(),
        )

        return finalDistance + totalDistance
    }
}

fun main() {
    val solution = TravelingSalesmanHeuristic()
    val result = solution.getMinimumCost()
    println("Total distance: $result")
}
