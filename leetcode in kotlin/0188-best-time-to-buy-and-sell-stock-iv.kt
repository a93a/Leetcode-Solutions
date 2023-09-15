class Solution {
    fun maxProfit(k: Int, prices: IntArray): Int {
        val n = prices.size
        val dp = Array (n) { Array (2) { IntArray (k + 1) { -1 } } }

        fun dfs(i: Int, buy: Int, k: Int): Int {
            if (i == n) return 0
            if (k == 0) return 0
            if (dp[i][buy][k] != -1) return dp[i][buy][k]

            var res = 0
            if (buy == 0) {
                res = maxOf(
                    dfs(i + 1, 0, k),
                    dfs(i + 1, 1, k) - prices[i]
                )
            } else {
                res = maxOf(
                    dfs(i + 1, 1, k),
                    prices[i] + dfs(i + 1, 0, k - 1)
                )
            }

            dp[i][buy][k] = res
            return res
        }

        return dfs(0, 0, k)
    }
}
