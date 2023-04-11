package leetcode.backtracking

class PalindromePartitioning {
    val cur = mutableListOf<String>()
    private val results = mutableListOf<List<String>>()
    fun partition(s: String): List<List<String>> {
        backtracking(0, s)

        return results.toList()
    }

    fun backtracking(index: Int, s: String) {
        if (index >= s.length) {
            results.add(cur.toList())
            return
        }

        val acc = StringBuilder()

        for (curIndex in index until s.length) {
            val curChar = s[curIndex]

            acc.append(curChar)

            if (isPalindrome(acc)) {
                cur.add(acc.toString())
                backtracking(curIndex + 1, s)
                cur.removeAt(cur.size - 1)
            }
        }
    }

    private fun isPalindrome(acc: StringBuilder): Boolean {
        var l = 0
        var r = acc.length - 1

        while (l < r) {
            if (acc[l] != acc[r]) {
                return false
            }

            l += 1
            r -= 1
        }

        return true
    }
}