class Solution {
    fun minPairSum(nums: IntArray): Int {
        nums.sort()
        val n = nums.size
        var res = -1
        for (i in 0 until n) {
            res = maxOf(res, nums[i] + nums[n - 1 - i])
        }
        return res
    }
}
