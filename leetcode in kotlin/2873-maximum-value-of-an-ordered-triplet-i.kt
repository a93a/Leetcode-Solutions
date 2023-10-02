// brute force, allowed since this is O(n^3) and n == 100
class Solution {
    fun maximumTripletValue(nums: IntArray): Long {
        val n = nums.size
        var max = Long.MIN_VALUE

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                for (k in j + 1 until n) {
                    var cur = (nums[i] - nums[j]).toLong() * nums[k]
                    max = maxOf(max, cur)
                }
            }
        }

        return if (max < 0L) 0L else max
    }
}

// optimized O(n)
class Solution {
    fun maximumTripletValue(nums: IntArray): Long {
        var res = 0L
        var maxIJ = 0
        var maxI = 0

        for (n in nums) {
            res = maxOf(res, 1L * maxIJ * n)
            maxI = maxOf(maxI, n)
            maxIJ = maxOf(maxIJ, maxI - n)
        }

        return res
    }
}
