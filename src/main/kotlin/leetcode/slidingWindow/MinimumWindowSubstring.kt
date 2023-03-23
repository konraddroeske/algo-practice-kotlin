

class MinimumWindowSubstring {
    private val diff = 'A'.toInt()
    private fun canRemove(
        leftIndex: Int,
        s: String,
        tCounter: IntArray,
        sCounter: IntArray,
    ): Boolean {
        val leftChar = s[leftIndex]

        return sCounter[leftChar.toInt() - diff] > tCounter[leftChar.toInt() - diff]
    }

    fun minWindow(s: String, t: String): String {
        val arrLength = 'z'.toInt() - diff + 1
        val sCounter = IntArray(arrLength)
        val tCounter = IntArray(arrLength)
        var matched = 0

        var leftIndex = 0
        var minWindow = ""

        for (char in t) {
            tCounter[char.toInt() - diff] += 1
        }

        for ((rightIndex, char) in s.withIndex()) {
            sCounter[char.toInt() - diff] += 1

            if (sCounter[char.toInt() - diff] <= tCounter[char.toInt() - diff]) {
                matched += 1
            }

            if (matched != t.length) {
                continue
            }

            while (canRemove(leftIndex, s, tCounter, sCounter)) {
                val leftChar = s[leftIndex]
                sCounter[leftChar.toInt() - diff] -= 1
                leftIndex += 1

                if (sCounter[leftChar.toInt() - diff] < tCounter[leftChar.toInt() - diff]) {
                    matched -= 1
                }
            }

            if (minWindow.isEmpty() || rightIndex - leftIndex + 1 < minWindow.length
            ) {
                minWindow = s.substring(leftIndex..rightIndex)
            }
        }

        return minWindow
    }
}
