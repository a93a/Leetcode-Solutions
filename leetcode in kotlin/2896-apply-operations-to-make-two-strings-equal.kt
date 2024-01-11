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
