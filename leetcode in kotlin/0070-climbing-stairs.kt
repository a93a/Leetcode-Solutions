// From recursion + memoization, to DP, to optimized DP.

// Recursion + memoization, O(n) time and O(n) space
class Solution {
    fun climbStairs(n: Int): Int {
        val dp = IntArray (n + 1) { -1 }
        
        fun dfs(i: Int): Int {
            if (i == n) return 1
            if (i > n) return 0
            if (dp[i] != -1) return dp[i]

            dp[i] = dfs(i + 1) + dfs(i + 2)
            return dp[i]
        }

        return dfs(0)
    }
}
// DP, O(n) time and O(n) space
class Solution {
    fun climbStairs(n: Int): Int {
        val dp = IntArray (n + 1)

        dp[0] = 1
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }
}

// DP with optimized space, O(n) time and O(1) space
class Solution {
    fun climbStairs(n: Int): Int {
        var first = 1
        var second = 1
        
        for (i in 2..n) {
            val cur = first + second
            first = second
            second = cur
        }

        return second
    }
}
