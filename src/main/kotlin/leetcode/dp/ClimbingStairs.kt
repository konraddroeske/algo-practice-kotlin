class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        if (n == 1 || n == 2) return n

        var prev2 = 1
        var prev1 = 2
        var total = prev1 + prev2

        repeat(n - 2) {
            total = prev2 + prev1
            prev2 = prev1
            prev1 = total
        }

        return total
    }
}