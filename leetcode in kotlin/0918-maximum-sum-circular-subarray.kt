class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        var globalMax = nums[0]
        var globalMin = nums[0]
        var curMax = 0
        var curMin = 0
        
        for (n in nums) {
            curMax = maxOf(curMax + n, n)
            curMin = minOf(curMin + n, n)
            globalMax = maxOf(globalMax, curMax)
            globalMin = minOf(globalMin, curMin)
        }

        return if (globalMax > 0) maxOf(globalMax, nums.sum()!! - globalMin) else globalMax
    }
}
