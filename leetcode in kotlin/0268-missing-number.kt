class Solution {
    fun missingNumber(nums: IntArray): Int {
        var amount = nums.size
        for(i in nums.indices){
            amount += i-nums[i]
        }
        return amount
    }
}

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

// Use reduce
class Solution {
    fun missingNumber(nums: IntArray): Int {
        var sum = (0..nums.size).reduce { a, v -> a + v }
        var sum2 = nums.sum() ?: 0
       return sum - sum2
    }
}
