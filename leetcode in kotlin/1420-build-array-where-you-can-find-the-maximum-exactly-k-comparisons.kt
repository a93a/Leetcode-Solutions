class Solution {
    fun numOfArrays(n: Int, m: Int, k: Int): Int {
        val mod = 1_000_000_000 + 7
        val dp = Array (n + 1) { Array (m + 1) { IntArray (k + 1) { -1 } } }

        fun dfs(n: Int, max: Int, k: Int): Int {
            if (n == 0) {
                if (k == 0) return 1
                else return 0
            }
            if (dp[n][max][k] != -1) return dp[n][max][k]

            var res = 0
            for (x in 1..max) {
                res = (res + dfs(n - 1, max, k)) % mod
            }

            if (k > 0 ) {
                for (x in (max + 1)..m) {
                    res = (res + dfs(n - 1, x, k - 1)) % mod
                }
            }

            dp[n][max][k] = res % mod
            return res % mod
        }

        return dfs(n, 0, k) % mod
    }
}
