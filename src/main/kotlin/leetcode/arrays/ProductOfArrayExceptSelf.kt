class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var leftProduct = 1

        for (index in result.indices) {
            result[index] = leftProduct
            leftProduct *= nums[index]
        }

        var rightProduct = 1

        for (index in result.indices.reversed()) {
            result[index] *= rightProduct
            rightProduct *= nums[index]
        }

        return result
    }
}
