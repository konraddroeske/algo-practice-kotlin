
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hash = HashMap<Int, Int>()

        nums.forEachIndexed { index, it ->
            val diff = target - it

            if (hash.contains(diff)) {
                return intArrayOf(hash.getValue(diff), index)
            }

            hash[it] = index
        }

        return intArrayOf(0, 0)
    }
}
