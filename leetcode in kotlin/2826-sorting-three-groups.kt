class Solution {
    fun minimumOperations(nums: List<Int>): Int {
        val n = nums.size
        val dp = IntArray (n) { 1 }

        var max = 1
        for (i in n - 1 downTo 0) {
            for (j in i + 1 until n) {
                if (nums[i] <= nums[j]) {
                    dp[i] = maxOf(dp[i], 1 + dp[j])
                }
            }
        }

        return n - (dp.max() ?: 1)
    }
}
