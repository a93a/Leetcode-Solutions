class Solution {
    fun minimumFuelCost(roads: Array<IntArray>, seats: Int): Long {
        var res = 0.0
        if (roads.size == 0) 
            return res.toLong()
        
        val adj = HashMap<Int, ArrayList<Int>>().apply {
            for ((u, v) in roads) {
                getOrPut(u) { arrayListOf() }.apply { add(v) }
                getOrPut(v) { arrayListOf() }.apply { add(u) }
            } 
        }
        
        fun dfs(node: Int, parent: Int): Double {
            var passengers = 0.0

            adj[node]?.forEach { child ->
                if (child != parent) {
                    val childPassengers = dfs(child, node)
                    passengers += childPassengers
                    res += Math.ceil(childPassengers / seats)
                }
            }

            return passengers + 1.0
        }

        dfs(0, -1)
        return res.toLong()
    }
}
