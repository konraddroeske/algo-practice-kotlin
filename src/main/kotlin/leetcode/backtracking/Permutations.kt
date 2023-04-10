package leetcode.backtracking

class Permutation {
    val result = mutableListOf<List<Int>>()
    val cur = mutableListOf<Int>()

    fun permute(nums: IntArray): List<List<Int>> {
        val visited = BooleanArray(nums.size)
        dfs(nums, visited)

        return result
    }

    fun dfs(nums: IntArray, visited: BooleanArray) {
        if (cur.size == nums.size) {
            result.add(cur.toList())
            return
        }

        for ((index, num) in nums.withIndex()) {
            if (!visited[index]) {
                cur.add(num)
                visited[index] = true

                dfs(nums, visited)

                cur.removeAt(cur.size - 1)
                visited[index] = false
            }
        }
    }
}