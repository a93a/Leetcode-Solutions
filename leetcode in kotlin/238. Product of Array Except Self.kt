class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        var prefix = 1
        for(i in 0..res.size-1){
            res[i] = prefix
            prefix *= nums[i]
        }
        var postfix = 1
        for(i in res.size-1 downTo 0){
            res[i] *= postfix
            postfix *= nums[i]
        }  
        return res
    }
}
