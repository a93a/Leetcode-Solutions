class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]; var current = 0
        for (i in nums){
            if(current < 0)
                current = 0
            current += i
            max = maxOf(max, current)
        }
        return max
    }
}
