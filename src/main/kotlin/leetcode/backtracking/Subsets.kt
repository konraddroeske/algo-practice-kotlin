package leetcode.backtracking

class Subsets {
    val result = mutableListOf<List<Int>>()
    private val subset = mutableListOf<Int>()
    fun getSubsets(nums: IntArray): List<List<Int>> {
        dfs(0, nums)

        return result.toList()
    }

    fun dfs(i: Int, nums: IntArray) {
        if (i >= nums.size) {
            result.add(subset.toList())
            return
        }

        // decision to add nums i
        subset.add(nums[i])
        dfs(i + 1, nums)

        // decision to not add nums i
        subset.removeAt(subset.size - 1)
        dfs(i + 1, nums)
    }
}