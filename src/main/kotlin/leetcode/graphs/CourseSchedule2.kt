package leetcode.graphs

// Time - O(v * e)
class CourseSchedule2 {
    fun findOrderKahnsAlgorithm(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        // Kahn's Algorithm for Topological Sort
        val graph = HashMap<Int, MutableList<Int>>().withDefault { mutableListOf() }
        val indegrees = HashMap<Int, Int>().withDefault { 0 }
        val totalCourses = mutableSetOf<Int>()

        // Create adjacency graph as hash map (tail to head)
        // Create in-degree array
        for (prereq in prerequisites) {
            val head = prereq[0]
            val tail = prereq[1]

            val edges = graph.getValue(tail)
            edges.add(head)
            graph[tail] = edges

            indegrees[head] = indegrees.getValue(head) + 1
            indegrees[tail] = indegrees.getValue(tail)

            totalCourses.add(head)
            totalCourses.add(tail)
        }

        val queue = ArrayDeque<Int>()

        // Find nodes w/o dependencies, add to queue
        for (index in 0 until numCourses) {
            if (indegrees.getValue(index) == 0) {
                queue.add(index)
            }
        }

        val topOrdering = mutableListOf<Int>()

        // Pop first, add node to path arr, remove edges from neighbours
        // if neighbour's edge == 0, add to queue
        while (queue.isNotEmpty()) {
            val curNode = queue.removeFirst()
            topOrdering.add(curNode)

            val neighbours = graph.getValue(curNode)

            for (neighbour in neighbours) {
                indegrees[neighbour] = indegrees.getValue(neighbour) - 1

                if (indegrees[neighbour] == 0) {
                    queue.add(neighbour)
                }
            }
        }

        // check for cycles
        if (topOrdering.size != numCourses) {
            return intArrayOf()
        }

        // if top ordering length != totalCourses, return false
        return when {
            numCourses >= totalCourses.size -> topOrdering.toIntArray()
            else -> intArrayOf()
        }
    }

    fun findOrderDFS(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = Array(numCourses) { mutableListOf<Int>() }

        for (course in prerequisites) {
            val head = course[0]
            val tail = course[1]

            graph[head].add(tail)
        }

        val results = mutableListOf<Int>()
        val visited = BooleanArray(numCourses)
        val cycle = BooleanArray(numCourses)

        for (course in graph.indices) {
            if (!dfs(course, cycle, visited, graph, results)) {
                return intArrayOf()
            }
        }

        return results.toIntArray()
    }

    fun dfs(
        course: Int,
        cycle: BooleanArray,
        visited: BooleanArray,
        graph: Array<MutableList<Int>>,
        results: MutableList<Int>,
    ): Boolean {
        if (cycle[course]) {
            return false
        }

        if (visited[course]) {
            return true
        }

        cycle[course] = true

        for (prereq in graph[course]) {
            if (!dfs(prereq, cycle, visited, graph, results)) {
                return false
            }
        }

        cycle[course] = false
        visited[course] = true
        results.add(course)

        return true
    }
}
