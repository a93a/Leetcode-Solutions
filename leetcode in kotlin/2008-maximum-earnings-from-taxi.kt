// Sort + recursion & memoization + binary search
class Solution {
    fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {
        val rd = rides.sortedWith(compareBy({ it[0] }, { it[1] }))
        val dp = LongArray (rd.size) { -1L }

        fun dfs(i: Int): Long {
            if (i == rd.size) return 0L
            if (dp[i] != -1L) return dp[i]

            var l = i + 1
            var r = rd.lastIndex
            var j = rd.size
            while (l <= r) {
                val m = (l + r) / 2
                if (rd[m][0] >= rd[i][1]) {
                    r = m - 1
                    j = m
                } else {
                    l = m + 1
                }
            }

            dp[i] = maxOf(
                dfs(i + 1),
                dfs(j) + rd[i][1] - rd[i][0] + rd[i][2]
            )

            return dp[i]
        }

        return dfs(0)
    }
}

// knacksack DP
class Solution {
    fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {
        val rd = rides.sortedWith(compareBy({ it[0] }, { it[1] }))
        val dp = LongArray (n + 1)
        var j = 0
        for (i in 1..n) {
            dp[i] = maxOf(
                dp[i], 
                dp[i - 1]
            )
            while (j < rd.size && rd[j][0] == i) {
                dp[rd[j][1]] = maxOf(
                    dp[rd[j][1]],
                    dp[i] + rd[j][1] - rd[j][0] + rd[j][2]
                )
                j++
            }
        }

        
        return dp[n]
    }
}
