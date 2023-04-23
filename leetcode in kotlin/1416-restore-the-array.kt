class Solution {
    fun numberOfArrays(s: String, k: Int): Int {
        val mod = 1000000000 + 7
        val n = s.length
        val dp = IntArray(n + 1)

        dp[n] = 1
        for (i in n - 1 downTo 0) {
            var num = 0L
            var noOfWays = 0L

            for (j in i until n) {
                num = (num * 10) + (s[j] - '0')
                if (num !in (1..k)) break
                noOfWays = (noOfWays + dp[j + 1]) % mod
            }
            
            dp[i] = noOfWays.toInt()
        }

        return dp[0]
    }
}
