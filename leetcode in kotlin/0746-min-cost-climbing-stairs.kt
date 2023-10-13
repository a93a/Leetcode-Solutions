// Solutions ranging from brute force recursion (Time: O(2^n)) down to optimized DP (Time: O(n) and Space: O(1)) 

// Brute force recursion. Time: O(2^n) and Space: O(n)
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size

        fun dfs(i: Int): Int {
            if (i == 0 || i == 1) return cost[i]

            return cost[i] + minOf(
                dfs(i - 1),
                dfs(i - 2)
            )
        }

        return minOf(
            dfs(n - 1),
            dfs(n - 2)
        )
    }
}

// Optimized recursion with memoization. Time: O(n^2) and Space: O(n)
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        val cache = IntArray (n) { -1 }

        fun dfs(i: Int): Int {
            if (i == 0 || i == 1) return cost[i]
            if (cache[i] != -1) return cache[i]

            cache[i] = cost[i] + minOf(
                dfs(i - 1),
                dfs(i - 2)
            )

            return cache[i]
        }

        return minOf(
            dfs(n - 1),
            dfs(n - 2)
        )
    }
}

// Dp. Time: O(n) and Space: O(n)
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {    
        val n = cost.size
        val dp = IntArray (n).apply {
            this[0] = cost[0]
            this[1] = cost[1]
        }

        for (i in 2 until n) {
            dp[i] = cost[i] + minOf(
               dp[i - 1],
               dp[i - 2]
           )
        }
        
        return minOf(
            dp[n - 1], 
            dp[n - 2]
        )
    }
}

// Optimized space DP (input data manipulation) solution Time: O(n) and Space: O(1)
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {    
        val n = cost.lastIndex
        
        for (i in 2 until n) {
           cost[i] += minOf(
               cost[i - 1],
               cost[i - 2]
           )
        }
        
        return minOf(
            cost[n - 1], 
            cost[n - 2]
        )
    }
}

// Optimized space DP without input data manipulation. solution Time: O(n) and Space: O(1)
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {    
        val n = cost.size
        var prevPrev = cost[0]
        var prev = cost[1]

        for (i in 2 until n) {
            val temp = prev
            prev = cost[i] + minOf(
               prev,
               prevPrev
           )
           prevPrev = temp
        }
        
        return minOf(
            prev, 
            prevPrev
        )
    }
}
