/*
* DFS + memoization
*/
class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val dp = Array(s1.length + 1) { IntArray(s2.length + 1) {-1} }

        fun calcRest(s: String, i: Int): Int {
            var sum = 0
            for (j in i until s.length)
                    sum += s[j].toInt()
                return sum
        }

        fun dfs(i: Int, j: Int): Int {
            if (i == s1.length && j == s2.length)
                return 0
            if (i == s1.length)     
                return calcRest(s2, j)
            if (j == s2.length)
                return calcRest(s1, i) 
            if (dp[i][j] != -1)
                return dp[i][j]

            if (s1[i] == s2[j]) {
                dp[i][j] = dfs(i + 1, j + 1)
            } else {
                dp[i][j] = minOf(
                    s1[i].toInt() + dfs(i + 1, j),
                    s2[j].toInt() + dfs(i, j + 1)
                )
            }

            return dp[i][j]
        }

        return dfs(0, 0)
    }
}

/*
* DP
*/
class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }

        for (i in s1.lastIndex downTo 0 ) {
            for (j in s2.lastIndex downTo 0) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = s1[i].toInt() + dp[i + 1][j + 1]
                } else {
                    dp[i][j] = maxOf(
                        dp[i + 1][j],
                        dp[i][j + 1]
                    )
                }
            }
        }

        var sum = 0
        for (c in s1)
            sum += c.toInt()
        for (c in s2)
            sum += c.toInt()

        return sum - dp[0][0] * 2
    }
}

/*
* DP with space optimization O(n)
*/
class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        var prev = IntArray(s2.length + 1)

        for (i in s1.lastIndex downTo 0 ) {
            val dp = IntArray(s2.length + 1)
            for (j in s2.lastIndex downTo 0) {
                if (s1[i] == s2[j]) {
                    dp[j] = s2[j].toInt() + prev[j + 1]
                } else {
                    dp[j] = maxOf(
                        dp[j + 1],
                        prev[j]
                    )
                }
            }
            prev = dp
        }

        var sum = 0
        for (c in s1)
            sum += c.toInt()
        for (c in s2)
            sum += c.toInt()

        return sum - prev[0] * 2
    }
}
