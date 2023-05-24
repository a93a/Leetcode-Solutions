class Solution {
    fun maxJumps(arr: IntArray, d: Int): Int {
        val dp = IntArray(arr.size) { -1 }

        fun dfs(i: Int): Int {
            if (dp[i] != -1)
                return dp[i]

            dp[i] = 1

            for (j in (i + 1)..minOf(i + d, arr.lastIndex)) {
                if (arr[j] >= arr[i])   
                    break
                dp[i] = maxOf(dp[i], 1 + dfs(j))
            }

            for (j in (i - 1) downTo maxOf(i - d, 0)) {
                if (arr[j] >= arr[i]) 
                    break
                dp[i] = maxOf(dp[i], 1 + dfs(j))
            }

            return dp[i]
        }
 
        var res = 1
        for (i in 0 until arr.size)
            res = maxOf(res, dfs(i))

        return res
    }
}
