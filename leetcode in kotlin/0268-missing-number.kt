class Solution {
    fun missingNumber(nums: IntArray): Int {
        var amount = nums.size
        for(i in nums.indices){
            amount += i-nums[i]
        }
        return amount
    }
}

/*
//another solution using xor
class Solution {
    fun missingNumber(nums: IntArray): Int {
        var amount = nums.size
        for(i in nums.indices){
            amount = amount xor (i xor nums[i])
        }
        return amount
    }
}
*/
