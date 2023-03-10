import java.io.File
import java.nio.file.Paths

fun importClauses(filename: String): List<Pair<Int, Int>> {
    val dir = Paths.get(
        "src",
        "main",
        "kotlin",
        "stanfordAlgorithms",
        "part4",
        "week4",
    )
        .toAbsolutePath()
        .toString()

    val pathname = "$dir/$filename"

    val clauses = mutableListOf<Pair<Int, Int>>()

    File(pathname).useLines { lines ->
        lines.forEachIndexed { index, it ->
            if (index > 0) {
                val result = it.split(" ")
                clauses.add(
                    Pair(
                        result[0].toInt(),
                        result[1].toInt(),
                    ),
                )
            }
        }
    }

    return clauses.toList()
}

class TwoSatProblem {
    private var finishingTime = 0
    private var visited = mutableSetOf<Int>()
    private var finishingTimes = mutableListOf<Pair<Int, Int>>()
    private var sourceVertex: Int? = null

    private fun dfsLeader(
        graph: MutableMap<Int, IntArray>,
        vertex: Int,
    ): Boolean {
        if (sourceVertex != null && (vertex + sourceVertex!! == 0)) {
            return false
        }

        visited.add(vertex)
        val neighbours = graph.getValue(vertex)

        for (neighbour in neighbours) {
            if (!visited.contains(neighbour) && !dfsLeader(graph, neighbour)) {
                return false
            }
        }

        return true
    }

    private fun dfsFinishingTimes(graphRev: MutableMap<Int, IntArray>, vertex: Int) {
        visited.add(vertex)

        val neighbours = graphRev.getValue(vertex)

        for (neighbour in neighbours) {
            if (!visited.contains(neighbour)) {
                dfsFinishingTimes(graphRev, neighbour)
            }
        }

        finishingTime += 1
        finishingTimes.add(Pair(vertex, finishingTime))
    }

    private fun getGraph(clauses: List<Pair<Int, Int>>): MutableMap<Int, IntArray> {
        val graph = HashMap<Int, IntArray>().withDefault {
            intArrayOf()
        }

        for (clause in clauses) {
            graph[-clause.first] = graph.getValue(-clause.first) + intArrayOf(clause.second)
            graph[-clause.second] = graph.getValue(-clause.second) + intArrayOf(clause.first)
        }

        return graph
    }

    private fun reverseGraph(graph: MutableMap<Int, IntArray>): MutableMap<Int, IntArray> {
        val reversed = HashMap<Int, IntArray>().withDefault { intArrayOf() }

        for ((tail, heads) in graph) {
            for (head in heads) {
                reversed[head] = reversed.getValue(head) + intArrayOf(tail)
            }
        }

        return reversed
    }

    fun isSatisfiable(clauses: List<Pair<Int, Int>>): Boolean {
        val graph = getGraph(clauses)
        val graphRev = reverseGraph(graph)

        val vertices = graphRev.keys.toMutableList().sortedDescending()
            .toIntArray()

        // First Pass
        for (vertex in vertices) {
            if (visited.contains(vertex)) {
                continue
            }

            dfsFinishingTimes(graphRev, vertex)
        }

        // Second Pass
        visited = mutableSetOf()

        for ((vertex, _) in finishingTimes.sortedByDescending { it.second }) {
            if (visited.contains(vertex)) {
                continue
            }

            sourceVertex = vertex
            val result = dfsLeader(graph, vertex)

            if (!result) {
                return false
            }
        }

        return true
    }
}

fun main() {
    val solution = TwoSatProblem()

    for (index in 0..6) {
        val clauses = importClauses("2sat$index.txt")
        val result = solution.isSatisfiable(clauses)
        println("result $index: $result")
    }
}
