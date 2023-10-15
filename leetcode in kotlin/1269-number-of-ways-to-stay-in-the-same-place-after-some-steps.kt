class Solution {
    fun numWays(steps: Int, arrLen: Int): Int {
        val mod = 1_000_000_000 + 7
        val dp = Array (steps + 1) { IntArray (steps + 1) { -1 } }

        fun dfs(i: Int, left: Int): Int {
            if (i < 0 || i == arrLen) return 0
            if (left == 0) {
                if (i == 0) return 1
                else return 0
            }
            if (dp[i][left] != -1) return dp[i][left]

            var res = 0
            res = (res + dfs(i - 1, left - 1)) % mod
            res = (res + dfs(i + 1, left - 1)) % mod
            res = (res + dfs(i, left - 1)) % mod

            dp[i][left] = res
            return res
        }

        return dfs(0, steps)
    }
}
