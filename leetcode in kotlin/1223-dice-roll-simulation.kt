// recursion + memoization
class Solution {
    fun dieSimulator(n: Int, rollMax: IntArray): Int {
        val mod = 1_000_000_007
        val dp = Array (n + 1) { Array (6) { IntArray (16) { -1 } } }
        
        fun dfs(n: Int, prev: Int, count: Int): Int {
            if (n == 0) return 1
            if (dp[n][prev][count] != -1) return dp[n][prev][count]
        
            var res = 0L
            for (side in 0..5) {
                if (side == prev && count + 1 > rollMax[prev])
                    continue
                var newCount = if (side == prev) count + 1 else 1
                res += dfs(n - 1, side, newCount)
                res %= mod
            }

            dp[n][prev][count] = res.toInt()
            return dp[n][prev][count]
        }

        var res = 0L
        for (side in 0..5) {
            res += dfs(n - 1, side, 1)
            res %= mod
        }

        return res.toInt()
    }
}

// DP
class Solution {
    fun dieSimulator(n: Int, rollMax: IntArray): Int {
        val mod = 1_000_000_007
        val dp = Array (n) { Array (6) { LongArray (16) } }
        
        for (j in 0..5)
            dp[0][j][1] = 1

        for (i in 1 until n) {
            for (j in 0..5) {
                for (k in 1..rollMax[j]) {
                    if (k > 1) {
                        dp[i][j][k] = dp[i - 1][j][k - 1]
                    } else {
                        for (j2 in 0..5) {
                            for (k2 in 1..rollMax[j2]) {
                                if (j2 == j) continue
                                dp[i][j][k] += dp[i - 1][j2][k2]
                                dp[i][j][k] = dp[i][j][k] % mod
                            }
                        }
                    }
                }
            }
        }

        var res = 0L
        for (j in 0..5) {
            for (k in 1..rollMax[j]) {
                res += dp[n - 1][j][k]
                res %= mod
            }
        }

        return res.toInt()
    }
}
