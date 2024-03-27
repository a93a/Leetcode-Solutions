class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var res = 0
        var sum = 1
        var l = 0
        for (r in 0 until nums.size) {
            sum *= nums[r]
            while (l <= r && sum >= k) {
                sum /= nums[l++]
            }
            res += r - l + 1
        }
        return res
    }
}
