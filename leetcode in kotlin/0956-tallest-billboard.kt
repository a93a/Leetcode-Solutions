class Solution {
    fun tallestBillboard(r: IntArray): Int {
        val dp = Array (21) { IntArray (10001) { -1 } }

        fun dfs(i: Int, d: Int): Int {
            if (i == r.size) {
                return if (d == 0) 0 else Integer.MIN_VALUE
            }

            if (dp[i][5000 + d] != -1) return dp[i][5000 + d]

            dp[i][5000 + d] = maxOf(
                dfs(i + 1, d),
                r[i] + dfs(i + 1, d + r[i]),
                dfs(i + 1, d - r[i])
            )

            return dp[i][5000 + d]
        }

        return dfs(0, 0)
    }
}
