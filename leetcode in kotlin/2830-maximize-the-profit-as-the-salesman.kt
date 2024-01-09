// Sort + recursion & memoization + binary search
class Solution {
    fun maximizeTheProfit(n: Int, offers: List<List<Int>>): Int {
        val o = offers.sortedWith(compareBy({it[0]}, {it[1]}))
        val dp = IntArray (o.size) { -1 }

        fun dfs(i: Int): Int {
            if (i == o.size) return 0
            if (dp[i] != -1) return dp[i]

            var l = i + 1
            var r = o.lastIndex
            var j = o.size
            while (l <= r) {
                val m = (l + r) / 2
                if (o[m][0] > o[i][1]) {
                    r = m - 1
                    j = m
                } else {
                    l = m + 1
                }
            }

            dp[i] = maxOf(
                dfs(i + 1),
                o[i][2] + dfs(j)
            )

            return dp[i]
        }

        return dfs(0)
    }
}
