class Solution {
    fun canCross(stones: IntArray): Boolean {
        val jumps = HashMap<Int, Int>().apply {
            for ((i, s) in stones.withIndex())
                this[s] = i
        }
        val dp = HashMap<Pair<Int, Int>, Boolean>()
        
        fun dfs(i: Int, k: Int): Boolean {
            if (i == stones.lastIndex) return true
            if ((i to k) in dp) return dp[i to k]!!

            val cur = stones[i]
            for (next in (k - 1)..(k + 1)) {
                if (next > 0 && jumps.contains(cur + next)) {
                    if (dfs(jumps[cur + next]!!, next)) {
                        dp[i to k] = true
                        return true
                    }
                }
            }

            dp[i to k] = false
            return false
        }

        if (stones[1] != 1) return false
        return dfs(1, 1)
    }
}
