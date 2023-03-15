package leetcode.twoPointers
class TwoSum2 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val result = HashMap<Int, Int>()

        for ((curIndex, num) in numbers.withIndex()) {
            val diff = target - num

            if (result.contains(diff)) {
                val prevIndex = result.getValue(diff) + 1
                return intArrayOf(prevIndex, curIndex + 1)
            }

            result[num] = curIndex
        }

        return intArrayOf(0, 0)
    }

    fun twoSumTwoPointer(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            val sumVal = numbers[left] + numbers[right]

            if (sumVal == target) {
                return intArrayOf(left + 1, right + 1)
            } else if (target < sumVal) {
                right -= 1
            } else {
                left += 1
            }
        }

        return intArrayOf(0, 0)
    }
}
