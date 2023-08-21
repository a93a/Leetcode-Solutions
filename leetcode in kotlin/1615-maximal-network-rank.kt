class Solution {
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        val adj = HashMap<Int, HashSet<Int>>().apply {
            for ((u, v) in roads) {
                this[u] = getOrDefault(u, HashSet<Int>()).apply { add(v) }
                this[v] = getOrDefault(v, HashSet<Int>()).apply { add(u) }
            }
        }

        var max = 0
        for (u in 0 until n) {
            for (v in u + 1 until n) {
                var res = (adj[u]?.size ?: 0) + (adj[v]?.size ?: 0)
                if ((adj[u]?.contains(v) ?: false) && (adj[v]?.contains(u) ?: false)) res--
                max = maxOf(max, res)
            }
        }

        return max
    }
}
