class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        var left = 0
        var right = nums.lastIndex 
        var end = nums.lastIndex
        val res = IntArray (nums.size)    

        while (left <= right) {
            val ls = nums[left] * nums[left]
            val rs = nums[right] * nums[right] 
            if (ls > rs) {
                res[end] = ls
                left++
            } else {
                res[end] = rs
                right--
            }
            end--
        }

        return res
    }
}
