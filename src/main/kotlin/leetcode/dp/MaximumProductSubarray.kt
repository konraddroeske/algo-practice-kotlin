package leetcode.dp

class MaximumProductSubarray {
    fun maxProductBruteForce(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        var maxValue = nums[0]

        for ((i, num) in nums.withIndex()) {
            var product = num
            maxValue = maxOf(maxValue, product)

            for (j in i + 1 until nums.size) {
                product *= nums[j]
                maxValue = maxOf(maxValue, product)
            }
        }

        return maxValue
    }

    fun maxProductDP(nums: IntArray): Int {
        var prevMax = nums[0]
        var prevMin = nums[0]
        var maxProduct = prevMax

        for (index in 1 until nums.size) {
            val curNum = nums[index]

            val tempMax = maxOf(
                curNum,
                curNum * prevMax,
                curNum * prevMin,
            )
            prevMin = minOf(
                curNum,
                curNum * prevMax,
                curNum * prevMin,
            )

            prevMax = tempMax
            maxProduct = maxOf(maxProduct, prevMax)
        }

        return maxProduct
    }
}

fun main() {
    val solution = MaximumProductSubarray()

    val nums1 = intArrayOf(2, 3, 0, 4, -1)
    val result1 = solution.maxProductDP(nums1)
    println("result1: $result1")

//    val nums2 = intArrayOf(-2, 0, -1)
//    val result2 = solution.maxProductDP(nums2)
//    println("result2: $result2")
//
//    val nums3 = intArrayOf(-2)
//    val result3 = solution.maxProductDP(nums3)
//    println("result3: $result3")
//
//    val nums4 = intArrayOf(2, -5, -2, -4, 3)
//    val result4 = solution.maxProductDP(nums4)
//    println("result4: $result4")
}
