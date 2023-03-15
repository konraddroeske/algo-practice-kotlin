package leetcode.twoPointers
class ContainerWithMostWater {
    private fun calcArea(left: Int, right: Int, height: IntArray): Int {
        return (right - left) * minOf(height[left], height[right])
    }
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var area = 0

        while (left < right) {
            area = maxOf(area, calcArea(left, right, height))

            if (height[left] < height[right]) {
                left += 1
            } else {
                right -= 1
            }
        }

        return area
    }
}
