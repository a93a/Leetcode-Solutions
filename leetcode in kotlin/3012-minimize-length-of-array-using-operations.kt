class Solution {
    fun minimumArrayLength(nums: IntArray): Int {
        val min = nums.min()!!

        for (n in nums)
            if (n % min > 0) return 1
        
        return (nums.count { it == min } + 1) / 2
    }
}
