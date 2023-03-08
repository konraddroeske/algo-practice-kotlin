package stanfordAlgorithms.part4.week2

import java.io.File
import java.nio.file.Paths
import kotlin.math.pow
import kotlin.math.sqrt

fun importDataset(filename: String): List<Pair<Double, Double>> {
    val dir = Paths.get(
        "src",
        "main",
        "kotlin",
        "stanfordAlgorithms",
        "part4",
        "week2",
    )
        .toAbsolutePath()
        .toString()

    val pathname = "$dir/$filename"

    val lineList = mutableListOf<Pair<Double, Double>>()

    File(pathname).useLines { lines ->
        lines.forEachIndexed { index, it ->
            if (index > 0) {
                val result = it.split(" ")
                lineList.add(Pair(result[0].toDouble(), result[1].toDouble()))
            }
        }
    }

    return lineList.toList()
}

class TravelingSalesman {
    fun calculateDistance(
        location1: Pair<Double, Double>,
        location2: Pair<Double, Double>,
    ): Double {
        val (x, y) = location1
        val (z, w) = location2

        return sqrt((x - z).pow(2) + (y - w).pow(2))
    }

    private fun getSubsets(setSize: Int): Map<Int, List<IntArray>> {
        val values = IntArray(setSize - 1) { it + 2 }
        val result = mutableListOf(intArrayOf(1))

        for (value in values) {
            val newSubset = result.map { it + value }
            result += newSubset
        }

        return result.groupBy { it.size }
    }

    private fun getDistances(locations: List<Pair<Double, Double>>): Array<DoubleArray> {
        val distances = Array(locations.size) { DoubleArray(locations.size) }

        for ((rowIndex, start) in distances.withIndex()) {
            for ((colIndex, _) in start.withIndex()) {
                distances[rowIndex][colIndex] = calculateDistance(locations[rowIndex], locations[colIndex])
            }
        }

        return distances
    }

    fun getMinimumCost(locations: List<Pair<Double, Double>>): Double {
        val subsetsMap = getSubsets(locations.size)
        val costsMap = HashMap<String, DoubleArray>().withDefault {
            DoubleArray(locations.size) { Double.POSITIVE_INFINITY }
        }
        val distances = getDistances(locations)

        // Base Values
        val baseSubsets = subsetsMap.getValue(1)

        for (subset in baseSubsets) {
            val subsetString = subset.joinToString("")
            costsMap[subsetString] = costsMap.getValue(subsetString)

            if (subset.contentEquals(intArrayOf(1))) {
                costsMap[subsetString]?.set(0, 0.0)
            }
        }

        for (subProblemSize in 2..locations.size) {
            val curSubsets = subsetsMap.getValue(subProblemSize)
            val prevSubsets = subsetsMap.getValue(subProblemSize - 1)

            for (curSubset in curSubsets) {
                val curCosts = costsMap.getValue(curSubset.joinToString(""))
                costsMap[curSubset.joinToString("")] = curCosts

                for (curLocation in curSubset) {
                    if (curLocation == 1) continue

                    val prevSubset = curSubset.filter { it != curLocation }.toIntArray()
                    val prevCosts = costsMap.getValue(prevSubset.joinToString(""))

                    for ((lastLocation, prevCost) in prevCosts.withIndex()) {
                        if (prevCost == Double.POSITIVE_INFINITY) {
                            continue
                        }

                        val lastCost = distances[lastLocation][curLocation - 1]
                        curCosts[curLocation - 1] = minOf(curCosts[curLocation - 1], prevCost + lastCost)
                    }
                }
            }

            for (prevSubset in prevSubsets) {
                costsMap.remove(prevSubset.joinToString(""))
            }
        }

        for (subset in subsetsMap.getValue(locations.size)) {
            println(subset.joinToString(""))
        }

        val finalCosts = costsMap.getValue(
            IntArray(locations.size) { it + 1 }.joinToString(""),
        )

        var result = Double.POSITIVE_INFINITY

        for ((lastLocation, prevCost) in finalCosts.withIndex()) {
            if (prevCost == Double.POSITIVE_INFINITY) {
                continue
            }

            val finalCost = calculateDistance(
                locations[lastLocation],
                locations[0],
            )
            result = minOf(result, finalCost + prevCost)
        }

        return result
    }
}

fun main() {
    val solution = TravelingSalesman()
    val locationsFinal = importDataset("tspInput.txt")

    val firstHalf = locationsFinal.slice(IntRange(0, 12))
    val secondHalf = locationsFinal.slice(IntRange(11, 24))

    val resultFirstHalf = solution.getMinimumCost(firstHalf)
    println("first half: $resultFirstHalf")

    val resultSecondHalf = solution.getMinimumCost(secondHalf)
    println("second half: $resultSecondHalf")

    val sharedDistance = solution.calculateDistance(
        firstHalf[11],
        firstHalf[12],
    )
    println("shared distance: $sharedDistance")

    val final = resultFirstHalf + resultSecondHalf - (2 * sharedDistance)

    println("final: $final")
}
