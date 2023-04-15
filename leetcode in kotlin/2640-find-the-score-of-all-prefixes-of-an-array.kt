class Solution {
    fun findPrefixScore(nums: IntArray): LongArray {
        var max = Integer.MIN_VALUE
        var sum = 0L
        var res = LongArray(nums.size)
        
        for (i in 0 until nums.size) {
            val curr = nums[i]
            max = maxOf(max, curr)
            
            sum = sum + max + curr
            res[i] = sum
        }
        
        return res
    }
}
