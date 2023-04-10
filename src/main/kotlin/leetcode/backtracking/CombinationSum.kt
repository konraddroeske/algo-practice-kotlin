package leetcode.backtracking
class CombinationSum {
    val result = mutableListOf<List<Int>>()
    private val combination = mutableListOf<Int>()
    fun getSum(candidates: IntArray, target: Int): List<List<Int>> {
        dfs(0, 0, candidates, target)

        return result.toList()
    }
    private fun dfs(index: Int, total: Int, candidates: IntArray, target: Int) {
        if (total == target) {
            result.add(combination.toList())
            return
        }

        if (index >= candidates.size || total > target) {
            return
        }

        combination.add(candidates[index])
        dfs(index, total + candidates[index], candidates, target)

        combination.removeAt(combination.size - 1)
        dfs(index + 1, total, candidates, target)
    }
}