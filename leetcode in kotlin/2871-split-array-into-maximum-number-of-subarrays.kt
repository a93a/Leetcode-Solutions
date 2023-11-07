class Solution {
    fun maxSubarrays(nums: IntArray): Int {
        var p = nums[0]
        for (n in nums)
            p = p and n
        
        if (p != 0)
            return 1
        
        var cur = Integer.MAX_VALUE
        var res = 0
        for (n in nums) {
            cur = cur and n

            if (cur == 0) {
                res++
                cur = Integer.MAX_VALUE
            }
        }

        return res
    }
}
