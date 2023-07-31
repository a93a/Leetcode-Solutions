class Solution {
    val dirs = arrayOf(
        intArrayOf(-2, -1),
        intArrayOf(-1, -2),
        intArrayOf(1, -2),
        intArrayOf(2, -1),
        intArrayOf(2, 1),
        intArrayOf(1, 2),
        intArrayOf(-1, 2),
        intArrayOf(-2, 1)
    )

    fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
        val dp = Array (n) { Array (n) { DoubleArray (k + 1) { -1.0 } } }

        fun dfs(i: Int, j: Int, k: Int): Double {
            if (i >= n || j >= n || i < 0 || j < 0) return 0.0
            if (k == 0) return 1.0
            if (dp[i][j][k] != -1.0) return dp[i][j][k]

            var res = 0.0
            for (dir in dirs) {
                res += (0.125 * dfs(i + dir[0], j + dir[1], k - 1))
            }

            dp[i][j][k] = res
            return res
        }

        return dfs(row, column, k)
    }
}
