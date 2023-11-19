class Solution {
    fun reductionOperations(nums: IntArray): Int {
        nums.sortDescending()
        val n = nums.size
        
        var res = 0
        for (i in 1 until n) {
            if (nums[i - 1] != nums[i])
                res += i
        }

        return res
    }
}
