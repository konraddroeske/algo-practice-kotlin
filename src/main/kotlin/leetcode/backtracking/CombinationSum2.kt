package leetcode.backtracking

import java.util.*

class CombinationSum2 {
    val result = mutableListOf<List<Int>>()
    val cur = mutableListOf<Int>()
    fun sum2(candidates: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(candidates)

        backtrack(0, target, candidates)

        return result.toList()
    }

    private fun backtrack(start: Int, target: Int, candidates: IntArray) {
        if (target == 0) {
            result.add(cur.toList())
        }

        if (target <= 0) {
            return
        }

        for (index in start until candidates.size) {
            val candidate = candidates[index]

            if (index > start && candidate == candidates[index - 1]) {
                continue
            }

            cur.add(candidate)
            backtrack(index + 1, target - candidate, candidates)
            cur.removeAt(cur.size - 1)
        }
    }
}