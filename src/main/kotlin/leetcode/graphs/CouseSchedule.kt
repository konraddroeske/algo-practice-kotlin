package leetcode.graphs

// Time - O(v * e)
class CourseSchedule {
    fun canFinishKahnsAlgorithm(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
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
        for ((node, incoming) in indegrees) {
            if (incoming == 0) {
                queue.add(node)
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
        // if top ordering length != totalCourses, return false
        if (topOrdering.size != totalCourses.size) return false

        // check if num courses >= total courses
        return numCourses >= totalCourses.size
    }

    fun canFinishDFS(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = Array(numCourses) { mutableListOf<Int>() }
        val visited = BooleanArray(numCourses) { false }

        for (course in prerequisites) {
            val head = course[0]
            val tail = course[1]

            graph[head].add(tail)
        }

        for (course in graph.indices) {
            if (!dfs(course, visited, graph)) {
                return false
            }
        }

        return true
    }

    fun dfs(
        course: Int,
        visited: BooleanArray,
        graph: Array<MutableList<Int>>,
    ): Boolean {
        if (visited[course]) {
            return false
        }

        if (graph[course].isEmpty()) {
            return true
        }

        visited[course] = true

        for (prereq in graph[course]) {
            val result = dfs(prereq, visited, graph)

            if (!result) {
                return false
            }
        }

        visited[course] = false
        graph[course] = mutableListOf()

        return true
    }
}
