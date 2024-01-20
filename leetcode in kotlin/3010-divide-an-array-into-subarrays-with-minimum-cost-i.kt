class Solution {
    fun minimumCost(nums: IntArray): Int {
        var first = nums[0]
        var second = Integer.MAX_VALUE
        var third = Integer.MAX_VALUE
        for (i in 1 until nums.size) {
            if (nums[i] < second) {
                third = second
                second = nums[i]
            } else {
                third = minOf(third, nums[i])
            }
        }
        
        return first + second + third
    }
}
