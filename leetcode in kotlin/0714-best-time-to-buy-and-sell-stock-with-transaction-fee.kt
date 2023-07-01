class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        val dp = Array (2) {IntArray (prices.size) { -1 } }
        var iter = 0

        fun dfs(i: Int, buy: Int): Int {
            if (i == prices.size) return 0
            if (dp[buy][i] != -1) return dp[buy][i]

            var res = dfs(i + 1, buy)
            if (buy == 1) 
                res = maxOf(res, dfs(i + 1, 0) - prices[i])
            else 
                res = maxOf(res, dfs(i + 1, 1) + prices[i] - fee)

            dp[buy][i] = res
            return res
        }

        return dfs(0, 1)
    }
}
