package leetcode.backtracking

import java.util.*

class Subsets2 {
    val result = mutableListOf<List<Int>>()
    val cur = mutableListOf<Int>()
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)

        dfs(nums, 0)

        return result.toList()
    }

    fun dfs(nums: IntArray, start: Int) {
        result.add(cur.toMutableList())

//        println("cur: $cur")
//        println("start: $start")

        for (index in start until nums.size) {
            if (index > start && nums[index] == nums[index - 1]) {
                continue
            }

            cur.add(nums[index])
            dfs(nums, index + 1)
            cur.removeAt(cur.size - 1)
        }
    }
}