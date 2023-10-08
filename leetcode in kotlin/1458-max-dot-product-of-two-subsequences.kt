class Solution {
    fun maxDotProduct(a: IntArray, b: IntArray): Int {
        val n = a.size
        val m = b.size
        val dp = Array (n) { IntArray (m) { -1 } }
        
        fun dfs(i: Int, j: Int): Int {
            if (i == n || j == m) return 0
            if (dp[i][j] != -1) return dp[i][j]

            var res = 0

            res = maxOf(res, dfs(i + 1, j))
            res = maxOf(res, dfs(i, j + 1))
            res = maxOf(res, dfs(i + 1, j + 1))
            res = maxOf(res, a[i] * b[j] + dfs(i + 1, j + 1))

            dp[i][j] = res
            return res
        }

        var res = dfs(0, 0)
        if (res == 0) {
            res = maxOf(a.max()!! * b.min()!!, b.max()!! * a.min()!!)
        }

        return res
    }
}
