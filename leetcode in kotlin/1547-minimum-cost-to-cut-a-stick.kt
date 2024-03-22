class Solution {
    fun minCost(n: Int, cuts: IntArray): Int {
        val c = cuts.toMutableList()
        c.add(0)
        c.add(n)
        c.sort()

        val dp = Array (c.size) { IntArray (c.size) { -1 } }

        fun dfs(l: Int, r: Int): Int {
            if (r - l <= 1) return 0
            if (dp[l][r] != -1) return dp[l][r]
            
            dp[l][r] = Integer.MAX_VALUE
            for (m in l + 1 until r) {
                dp[l][r] = minOf(
                    dp[l][r], 
                    dfs(l, m) + dfs(m, r) + (c[r] - c[l])
                )
            }    

            return dp[l][r]    
        }
    
        return dfs(0, c.lastIndex)
    } 
}
