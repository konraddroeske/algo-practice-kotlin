package leetcode.twoPointers

class TrappingRainWater {
    fun trap(height: IntArray): Int {
        var totalWater = 0

        var maxLeft = height[0]
        val maxRightArr = IntArray(height.size)
        var maxRight = 0

        for (rightIndex in height.size - 1 downTo 2) {
            maxRight = maxOf(maxRight, height[rightIndex])
            maxRightArr[rightIndex] = maxRight
        }

        for (curIndex in 1 until height.size - 1) {
            val curWater = minOf(maxLeft, maxRightArr[curIndex + 1]) - height[curIndex]
            totalWater += maxOf(curWater, 0)

            maxLeft = maxOf(maxLeft, height[curIndex])
        }

        return totalWater
    }

    fun trapTwoPointer(height: IntArray): Int {
        var left = 0
        var right = height.size - 1

        var leftMax = height[left]
        var rightMax = height[right]

        var totalWater = 0

        while (left < right) {
            if (leftMax < rightMax) {
                left += 1
                leftMax = maxOf(leftMax, height[left])
                totalWater += leftMax - height[left]
            } else {
                right -= 1
                rightMax = maxOf(rightMax, height[right])
                totalWater += rightMax - height[right]
            }
        }

        return totalWater
    }
}
