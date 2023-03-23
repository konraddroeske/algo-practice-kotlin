

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
        var minWindow = Pair(-1, -1)

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

            val minWindowLength = minWindow.second - minWindow.first

            if (minWindow.first == -1 || rightIndex - leftIndex <
                minWindowLength
            ) {
                minWindow = Pair(leftIndex, rightIndex)
            }
        }

        if (minWindow.first == -1) return ""

        return s.substring(minWindow.first..minWindow.second)
    }
}
