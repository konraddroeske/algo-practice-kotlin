class CarFleet {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        if (position.size == 1) return 1

        val finishTimes = DoubleArray(target) { -1.0 }

        for ((carIndex, curPos) in position.withIndex()) {
            finishTimes[curPos] = (target - curPos).toDouble() / speed[carIndex]
        }

        var groups = 0
        var prevTime = 0.0

        for (index in finishTimes.indices.reversed()) {
            val curFinishTime = finishTimes[index]

            if (curFinishTime > prevTime) {
                groups += 1
                prevTime = curFinishTime
            }
        }

        return groups
    }
}
