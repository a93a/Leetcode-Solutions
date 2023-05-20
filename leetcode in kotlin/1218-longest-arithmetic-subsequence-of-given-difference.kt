class Solution {
    fun longestSubsequence(nums: IntArray, d: Int): Int {
        val dp = HashMap<Int, Int>()

        var max = 1
        for (n in nums) {
            dp[n] = 1 + (dp[n - d]?: 0)
            max = maxOf(
                max, 
                dp[n]?: 0
            )
        }

        return max
    }
}
