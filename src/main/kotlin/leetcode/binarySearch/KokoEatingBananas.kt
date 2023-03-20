package leetcode.binarySearch

class KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = 0

        for (pile in piles) {
            right = maxOf(right, pile)
        }

        while (left <= right) {
            val bananasPerHour = (left - right) / 2 + right
            var curHours = 0

            for (pile in piles) {
                curHours += if (pile < bananasPerHour) {
                    1
                } else {
                    (pile + bananasPerHour - 1) / bananasPerHour
                }
            }

            if (curHours <= h) {
                right = bananasPerHour - 1
            } else {
                left = bananasPerHour + 1
            }
        }

        return left
    }
}
