// recursion + memoization Time O(n^2) and space O(n)
class Solution {
    fun numDecodings(s: String): Int {
        val n = s.length
        val nums = HashSet<String>().apply {
            (1..26).forEach { add(it.toString()) }
        }
        val dp = IntArray (n) { -1 }

        fun dfs(i: Int): Int {
            if (i > n) return 0
            if (i == n) return 1
            if (dp[i] != -1) return dp[i]
            
            var res = 0
            var c = s[i].toString()
            var c2 = if (i + 1 < n) s.substring(i, i + 2) else null

            if (c !in nums && (c2 == null || (c2 !in nums))) return 0
            if (c in nums)
                res += dfs(i + 1)
            if (c2 != null && c2 in nums)
                res += dfs(i + 2)

            dp[i] = res
            return res
        }

        return dfs(0)
    }
}

// dp Time O(n) and space O(n)
class Solution {
    fun numDecodings(s: String): Int {
        val n = s.length
        val nums = HashSet<String>().apply {
            (1..26).forEach { add(it.toString()) }
        }
        val dp = IntArray (n + 1).apply { this[n] = 1 }
        
        for (i in (n - 1) downTo 0) {
            if (s[i] == '0')
                dp[i] = 0
            else
                dp[i] = dp[i + 1]
            
            if (i + 1 < n && (s.substring(i, i + 2) in nums))
                dp[i] += dp[i + 2]
        }

        return dp[0]
    }
}
