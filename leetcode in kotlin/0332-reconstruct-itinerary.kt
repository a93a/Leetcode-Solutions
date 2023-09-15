class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val adj = HashMap<String, PriorityQueue<String>>()

        for ((u, v) in tickets) {
            adj[u] = adj.getOrDefault(u, PriorityQueue<String>()).apply { add(v) }
        }

        val res = LinkedList<String>()
        fun dfs(airport: String) {
            adj[airport]?.let {
                while (it.isNotEmpty()) {
                    dfs(it.poll())
                }
            }
            res.addFirst(airport)
        }

        dfs("JFK")
        return res
    }
}
