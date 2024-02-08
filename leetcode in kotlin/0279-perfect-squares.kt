// DP
class Solution {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1){n}

        dp[0] = 0
        for (target in 1..n) {
            for (num in 1..target) {
                val square = num * num
                if (target - square < 0) break
                dp[target] = minOf(dp[target], 1 + dp[target - square])
            }
        }

        return dp[n]
    }
}

// recursion (DFS) + memoization
class Solution {
    fun numSquares(n: Int): Int {
        val dp = IntArray (n + 1) { n }

        fun dfs(target: Int): Int {
            if (target < 4) return target
            if (dp[target] != n) return dp[target]
            
            var res = target
            for (num in 1..target) {
                val square = num * num
                if (target - square < 0) break
                res = minOf(
                    res, 
                    1 + dfs(target - square)
                )
            }
            
            dp[target] = res
            return res
        }

        return dfs(n)
    }    
}

// Math solution
class Solution {
    /*
     * Refer to https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem
     * and https://en.wikipedia.org/wiki/Legendre%27s_three-square_theorem
     */
    fun numSquares(n: Int): Int {
        if (isSquare(n)) return 1

        var n = n
        while (n and 3 == 0) n = n ushr 2

        if (n and 7 == 7) return 4

        val sqrtN = Math.sqrt(n.toDouble()).toInt()
        for (i in 1..sqrtN) {
            if (isSquare(n - i * i))
                return 2
        }

        return 3
    }

    private fun isSquare(n: Int): Boolean {
        val sqrtN = kotlin.math.sqrt(n.toDouble()).toInt()
        return sqrtN * sqrtN == n
    }
}
