class Solution {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val n = graph.size
        val cost = Array (n) { IntArray (n) { 1000000 } }

        var allVisited = 0
        repeat (n) {
            allVisited = allVisited shl 1
            allVisited = allVisited or 1
        }

        for ((u, edges) in graph.withIndex()) {
            cost[u][u] = 0
            for (v in edges) {
                cost[u][v] = 1
                cost[v][u] = 1
            }
        }

        for (i in 0 until n) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    cost[i][j] = minOf(
                        cost[i][j],
                        cost[i][k] + cost[k][j]
                    )
                }
            }
        }

        fun dfs(i: Int, _visited: Int, dp: Array<IntArray>): Int {
            if (_visited == allVisited) return 0
            if (dp[_visited][i] != -1) return dp[_visited][i]

            var visited = _visited
            var res = 1000000
            for (j in 0 until n) {
                if (1 and (visited shr j) == 0) {
                    visited = visited or (1 shl j)
                    res = minOf(res, cost[i][j] + dfs(j, visited, dp))
                    visited = visited xor (1 shl j)
                }
            }

            dp[_visited][i] = res
            return res
        }

        var res = 1000000
        for (i in 0 until n) { 
            val dp = Array (1 shl 12) { IntArray (n) { -1 } }
            res = minOf(res, dfs(i, 1 shl i, dp))
        }

        return res
    }
}
