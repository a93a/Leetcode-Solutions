class Solution {
    fun PredictTheWinner(nums: IntArray): Boolean {
        val dp = Array (nums.size) { IntArray (nums.size) { - 1 } }

        fun dfs(i: Int, j: Int): Int {
            if (i > j) return 0
            if (dp[i][j] != -1) return dp[i][j]

            val a = nums[i] + minOf(
                dfs(i + 1, j - 1),
                dfs(i + 2, j)
            )
            val b = nums[j] + minOf(
                dfs(i, j - 2),
                dfs(i + 1, j - 1)
            )

            dp[i][j] = maxOf(a, b)
            return dp[i][j]
        }

        return 2 * dfs(0, nums.lastIndex) >= nums.sum()!!
    }
}
