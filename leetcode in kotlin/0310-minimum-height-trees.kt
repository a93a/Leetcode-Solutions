class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return listOf(0)

        val adj = HashMap<Int, HashSet<Int>>().apply {
            for ((u, v) in edges) {
                this[u] = getOrDefault(u, HashSet<Int>()).apply { this.add(v) }
                this[v] = getOrDefault(v, HashSet<Int>()).apply { this.add(u) }
            }
        }

        val q = LinkedList<Int>().apply {
            for ((k,v) in adj) {
                if (v.size == 1) {
                    this.addFirst(k)
                }
            }
        }

        var left = n
        while (left > 2) {
            left -= q.size
            repeat(q.size) {
                val node = q.removeLast()
                adj[node]?.forEach {
                    adj[it]?.remove(node)
                    if (adj[it]?.size == 1)
                        q.addFirst(it)
                }
            }    
        }

        return q
    }
}
