class Solution {
    fun countPairsOfConnectableServers(edges: Array<IntArray>, k: Int): IntArray {
        val adj = HashMap<Int, MutableList<Pair<Int, Int>>>()
        var n = 0
        edges.forEach { (a, b, w) ->
            adj.getOrPut(a) { mutableListOf() }.apply { add(b to w) }
            adj.getOrPut(b) { mutableListOf() }.apply { add(a to w) }
            n = maxOf(n, a, b)
        }

        fun dfs(cur: Int, prev: Int, dist: Int): Int {
            var count = if (dist % k == 0) 1 else 0
            adj[cur]?.forEach { (next, w) ->
                if (next != prev) 
                    count += dfs(next, cur, dist + w)
            }
            return count
        }

        val res = IntArray (n + 1)
        for (node in 0..n) {
            var totalCount = 0
            var sum = 0
            adj[node]?.forEach { (next, w) ->
                val curCount = dfs(next, node, w)
                sum += totalCount * curCount
                totalCount += curCount
            }
            res[node] = sum
        }

        return res
    }
}
