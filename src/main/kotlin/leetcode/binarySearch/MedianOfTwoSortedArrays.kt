package leetcode.binarySearch

class MedianOfTwoSortedArrays {
    private fun getLeftAndRight(mid: Int, arr: IntArray): Pair<Double, Double> {
        val left = if (mid >= 0) {
            arr[mid].toDouble()
        } else {
            Double.NEGATIVE_INFINITY
        }

        val right = if (mid + 1 < arr.size) {
            arr[mid + 1].toDouble()
        } else {
            Double.POSITIVE_INFINITY
        }

        return Pair(left, right)
    }
    fun findMedian(nums1: IntArray, nums2: IntArray): Double {
        val total = nums1.size + nums2.size
        val half = total / 2

        val (a, b) = if (nums1.size <= nums2.size) {
            Pair(nums1, nums2)
        } else {
            Pair(nums2, nums1)
        }

        var left = 0
        var right = a.size - 1

        while (true) {
            val i = if (left + right >= 0) (left + right) / 2 else -1
            val j = half - i - 2

            val (aLeft, aRight) = getLeftAndRight(i, a)
            val (bLeft, bRight) = getLeftAndRight(j, b)

            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 == 1) {
                    return minOf(aRight, bRight)
                }

                return (maxOf(aLeft, bLeft) + minOf(aRight, bRight)) / 2.0
            } else if (aLeft > bRight) {
                right = i - 1
            } else {
                left = i + 1
            }
        }
    }
}
