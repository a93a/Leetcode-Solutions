class Solution {
    fun jobScheduling(s: IntArray, e: IntArray, p: IntArray): Int {
        val dp = IntArray (s.size) { -1 }

        val comb = s.mapIndexed { i, v -> 
            intArrayOf(v, e[i], p[i]) 
        }.sortedWith(Comparator { a, b -> 
            if (a[0] == b[0]) a[1] - b[1]
            else a[0] - b[0]
        })

        fun dfs(i: Int): Int {
            if (i == comb.size || i == -1) return 0
            if (dp[i] != -1) return dp[i]

            var l = i
            var r = comb.lastIndex
            var res = -1
            while (l <= r) {
                val m = (r + l) / 2
                if (comb[m][0] >= comb[i][1]) {
                    res = m
                    r = m - 1
                } else {
                    l = m + 1
                }
            }

            dp[i] = maxOf(
                dfs(i + 1),
                comb[i][2] + dfs(res)
            )
            
            return dp[i]
        }

        return dfs(0)
    }
}
