class Solution {
    fun minInsertions(s1: String): Int {
        val n = s1.length
        val s2 = s1.reversed()
        val dp = Array(n+1){ IntArray(n+1) }

        for (i in n-1 downTo 0) {
            for (j in n-1 downTo 0) {
                if (s1[i] == s2[j])
                    dp[i][j] = 1 + dp[i + 1][j + 1]
                else
                    dp[i][j] = maxOf(dp[i + 1][j], dp[i][j + 1])
            }
        }

        return s1.length - dp[0][0]
    }
}
