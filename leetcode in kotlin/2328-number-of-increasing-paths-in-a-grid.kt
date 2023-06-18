class Solution {
    fun countPaths(g: Array<IntArray>): Int {
        val m = g.size
        val n = g[0].size
        val mod = 1000000007
        val dp = Array (m) { IntArray(n) { -1 } }
        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )
        
        fun isValid(i: Int, j: Int) = i in (0 until m) && j in (0 until n)

        fun dfs(i: Int, j: Int): Int {
            if (dp[i][j] != -1) return dp[i][j]

            dp[i][j] = 1
            dirs.forEach {
                val i2 = i + it[0]
                val j2 = j + it[1]
                if (isValid(i2, j2) && g[i2][j2] > g[i][j]) {
                    dp[i][j] = (dp[i][j] + dfs(i2, j2)) % mod
                }
            }

            return dp[i][j]
        }

        var res = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                res = (res + dfs(i, j)) % mod
            }
        }

        return res
    }
}
