class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        var maxTemp = 0

        for (curDay in temperatures.indices.reversed()) {
            val curTemp = temperatures[curDay]

            if (curTemp >= maxTemp) {
                maxTemp = curTemp
                continue
            }

            var days = 1

            while (curTemp >= temperatures[curDay + days]) {
                days += result[curDay + days]
            }

            result[curDay] = days
        }

        return result
    }
}
