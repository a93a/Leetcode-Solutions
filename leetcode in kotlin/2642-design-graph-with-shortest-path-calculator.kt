class Graph(n: Int, edges: Array<IntArray>) {
    val adj = HashMap<Int, ArrayList<Pair<Int, Int>>>().apply {
        for (i in 0 until n)
            getOrPut(i) { arrayListOf() }
        for ((u, v, cost) in edges) {
            getOrPut(u) { arrayListOf() }.apply { add(v to cost) }
        }
    }

    fun addEdge(edge: IntArray) {
        val (u, v, cost) = edge
        adj.getOrPut(u) { arrayListOf() }.apply { add(v to cost) }
    }

    fun shortestPath(node1: Int, node2: Int): Int {
        val minHeap = PriorityQueue<Pair<Int, Int>> (compareBy { it.second })
        val distance = IntArray(adj.size) { Integer.MAX_VALUE }

        minHeap.add(node1 to 0)
        distance[node1] = 0

        while (minHeap.isNotEmpty()) {
            val (node, cost) = minHeap.poll()

            if (node == node2) return cost
            if (cost > distance[node]) continue

            adj[node]?.forEach { (next, nextCost) ->
                if (cost + nextCost < distance[next]) {
                    distance[next] = cost + nextCost
                    minHeap.add(next to cost + nextCost)
                }
            }
        }

        return -1
    }
}
