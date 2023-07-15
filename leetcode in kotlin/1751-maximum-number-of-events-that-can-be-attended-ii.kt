class Solution {
    fun maxValue(events: Array<IntArray>, k: Int): Int {
        val dp = Array (events.size) { IntArray (k + 1) { -1 } }

        val e = events.sortedWith(Comparator { a, b -> 
            if (a[0] == b[0])
                a[1] - b[1]
            else
                a[0] - b[0]
        })

        fun dfs(i: Int, k: Int): Int {
            if (i == -1 || i >= e.size || k == 0) return 0
            if (dp[i][k] != -1) return dp[i][k]

            var l = i
            var r = e.lastIndex
            var res = -1
            while (l <= r) {
                val m = (r + l) / 2
                if (e[m][0] > e[i][1]) {
                    res = m
                    r = m - 1
                } else {
                    l = m + 1
                }
            }

            dp[i][k] = maxOf(
                dfs(i + 1, k),
                e[i][2] + dfs(res, k - 1)
            )
            
            return dp[i][k]
        }

        return dfs(0, k)
    }
}
