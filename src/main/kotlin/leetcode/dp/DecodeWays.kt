package leetcode.dp

class DecodeWays {
    fun numDecodings(s: String): Int {
        var singlePrev = 1
        var doublePrev = 1

        for (index in s.indices) {
            val singleValid = s[index] != '0'
            val doubleValid = index > 0 && (
                s[index - 1] == '1' ||
                    (s[index - 1] == '2' && s[index] <= '6')
                )

            var count = 0

            if (singleValid) {
                count += singlePrev
            }

            if (doubleValid) {
                count += doublePrev
            }

            doublePrev = singlePrev
            singlePrev = count
        }

        return singlePrev
    }
}