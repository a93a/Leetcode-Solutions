// recursion + memoization O(n) time
class Solution {
    fun minOperations(s1: String, s2: String, x: Int): Int {
        val diffs = s1.withIndex()
            .filter { s2[it.index] != it.value }
            .map { it.index }

        if (diffs.size % 2 == 1) return -1

        var xd = x.toDouble()
        val dp = DoubleArray (diffs.size) { -0.0 }

        fun dfs(i: Int): Double {
            if (i == 0) return xd / 2
            if (i == -1) return 0.0
            if (dp[i] != -0.0) return dp[i]

            dp[i] = minOf(
                dfs(i - 1) + (xd / 2),
                dfs(i - 2) + diffs[i] - diffs[i - 1]
            )

            return dp[i]
        }

        return dfs(diffs.lastIndex).toInt()
    }
}

// DP O(n) time
class Solution {
    fun minOperations(s1: String, s2: String, x: Int): Int {
        val diffs = s1.withIndex()
            .filter { s2[it.index] != it.value }
            .map { it.index }

        if (diffs.size % 2 == 1) return -1
        if (diffs.size == 0) return 0

        val n = diffs.size
        var xd = x.toDouble()
        val dp = DoubleArray (n + 1) { Double.POSITIVE_INFINITY }
        dp[n] = 0.0
        dp[n - 1] = xd / 2

        for (i in n - 2 downTo 0) {
            dp[i] = minOf(
                dp[i + 1] + (xd / 2),
                dp[i + 2] - diffs[i] + diffs[i + 1]
            )
        }

        return dp[0].toInt()
    }
}

// DP spaceoptimized to O(1)
class Solution {
    fun minOperations(s1: String, s2: String, x: Int): Int {
        val diffs = s1.withIndex()
            .filter { s2[it.index] != it.value }
            .map { it.index }

        if (diffs.size % 2 == 1) return -1
        if (diffs.size == 0) return 0

        val n = diffs.size
        var xd = x.toDouble()
        var prevPrev = 0.0
        var prev = xd / 2
        var cur = Double.POSITIVE_INFINITY

        for (i in n - 2 downTo 0) {
            cur = minOf(
                prev + (xd / 2),
                prevPrev - diffs[i] + diffs[i + 1]
            )
            prevPrev = prev
            prev = cur
        }

        return cur.toInt()
    }
}
