package leetcode.dp

class HouseRobber {
    fun rob(nums: IntArray): Int {
        val resultArr = IntArray(nums.size)

        for (index in nums.indices) {
            val case1 = if (index < 1) 0 else resultArr[index - 1]

            val prevResult = if (index < 2) 0 else resultArr[index - 2]
            val case2 = nums[index] + prevResult

            resultArr[index] = maxOf(case1, case2)
        }

        println(resultArr.contentToString())

        return resultArr[nums.size - 1]
    }
}

fun main() {
    val houseRobber = HouseRobber()

    val nums1 = intArrayOf(1, 2, 3, 1)
    val result1 = houseRobber.rob(nums1)
    println("result 1: $result1")

    val nums2 = intArrayOf(2, 7, 9, 3, 1)
    val result2 = houseRobber.rob(nums2)
    println("result 2: $result2")

    val nums3 = intArrayOf(2, 1, 1, 2)
    val result3 = houseRobber.rob(nums3)
    println("result 3: $result3")
}
