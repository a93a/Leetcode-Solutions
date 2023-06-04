class Solution {
    fun ways(pizza: Array<String>, k: Int): Int {
        val rows = pizza.size
        val cols = pizza[0].length
        val mod = 1000000007
        val dp = Array (rows) { Array (cols) { IntArray(k) { -1 } } }
        val apples = Array (rows + 1) { IntArray(cols + 1) }

        for (r in rows - 1 downTo 0) {
            for (c in cols - 1 downTo 0) {
                apples[r][c] = apples[r][c + 1] + apples[r + 1][c] - apples[r + 1][c + 1] + (if (pizza[r][c] == 'A') 1 else 0)
            } 
        }

        fun dfs(r: Int, c: Int, cuts: Int): Int {
            if (apples[r][c] == 0)
                return 0
            if (cuts == 0)
                return 1
            if (dp[r][c][cuts] != -1)
                return dp[r][c][cuts]
                
            dp[r][c][cuts] = 0
            
            for (rNext in r + 1 until rows) {
                if (apples[r][c] - apples[rNext][c] > 0) {
                    dp[r][c][cuts] = (dp[r][c][cuts] +  dfs(rNext, c, cuts - 1)) % mod
                }   
            }

            for (cNext in c + 1 until cols) {
                if (apples[r][c] - apples[r][cNext] > 0) {
                   dp[r][c][cuts] = (dp[r][c][cuts] +  dfs(r, cNext, cuts - 1)) % mod
                }  
            }

            return dp[r][c][cuts]
        }

        return dfs(0, 0, k - 1)
    }
}
