class Solution {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        var res = Int.MAX_VALUE
        for (l in nums.indices) {
            var sum = 0
            for (r in l until nums.size) {
                sum = sum or nums[r]
                if (sum >= k) res = minOf(res, r - l + 1)
            }
        }
        
        return if (res == Int.MAX_VALUE) -1 else res
    }
}
