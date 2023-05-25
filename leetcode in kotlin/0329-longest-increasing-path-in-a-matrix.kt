class Solution {
    fun longestIncreasingPath(m: Array<IntArray>): Int {
        val dp = Array (m.size) { IntArray (m[0].size) }

        val cord = arrayOf(
            intArrayOf(1,0),
            intArrayOf(-1,0),
            intArrayOf(0,1),
            intArrayOf(0,-1)
        )

        fun isValid(i: Int, j: Int) = i in (0 until m.size) && j in (0 until m[0].size)
        
        fun dfs(i: Int, j: Int, prev: Int): Int {
            if (!isValid(i, j) || prev >= m[i][j])
                return 0
            if (dp[i][j] > 0)
                return dp[i][j]

            dp[i][j] = 1

            for (c in cord) {
                dp[i][j] = maxOf(
                    dp[i][j], 
                    1 + dfs(i + c[0], j + c[1], m[i][j])
                )
            }
                
            return dp[i][j]
        }

        var max = 1

        for (i in 0 until m.size) {
            for (j in 0 until m[0].size) {
                max = maxOf(
                    max, 
                    dfs(i, j, Int.MIN_VALUE)
                )
            }
        }

        return max
    }
}
