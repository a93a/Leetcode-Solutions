//DP time O(n^2) and space O(n)
class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        var dp = IntArray (n) { 1 }

        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[j] += dp[j - 1]
            }
        }

        return dp[n - 1]
    }
}

// DP time O(n^2) and space O(n^2)
class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val grid = Array (m) { IntArray(n) }

        for (i in 0 until m)
            grid[i][0] = 1
        for (j in 0 until n)
            grid[0][j] = 1
            
        for (i in 1 until m) {
            for (j in 1 until n)
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1]
        }

        return grid[m - 1][n - 1]
    }
}

// recursion + memoization time O(n^2) and space O(n^2)
class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array (m) { IntArray (n) { -1 } }

        fun dfs(x: Int, y: Int): Int {
            if (x == m - 1 && y == n - 1) return 1
            if (dp[x][y] != -1) return dp[x][y]
            
            var res = 0
            if (x + 1 < m) res += dfs(x + 1, y)
            if (y + 1 < n) res += dfs(x, y + 1)
            
            dp[x][y] = res
            return res
        }

        return dfs(0, 0)
    }
}

//combinatorics O((m+n)!/(m!*n!)) time and space O(1)
class Solution {
    fun uniquePaths(_m: Int, _n: Int): Int {
        if (_m == 1 || _n == 1) return 1

        var m = _m - 1
        var n = _n - 1

        if (m < n) {
            m = n.also { n = m }
        }

        var res = 1L
        var j = 1
        var i = m + 1
        while (i <= (m + n)) {
            res *= i
            res /= j
            i++
            j++
        }

        return res.toInt()
    }
}
