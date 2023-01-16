class Solution {
    fun singleNumber(nums: IntArray): Int {
        var missing = 0
        for(i in 0..nums.size-1){
            missing = missing xor nums[i]
        }
        return missing
    }
}
