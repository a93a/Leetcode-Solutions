class Solution {
    fun numBusesToDestination(_routes: Array<IntArray>, source: Int, target: Int): Int {
        val routes = _routes.map { it.toMutableList() }

        val stops = HashMap<Int, HashSet<Int>>().apply {
            for (i in 0 until routes.size) {
                routes[i]?.forEach { stop ->
                    getOrPut(stop) { hashSetOf() }.apply { add(i) }
                }
            }
        }

        val q = LinkedList<Pair<Int, Int>>().apply { addLast(source to 0) }
        val visit = HashSet<Int>()
        while (q.isNotEmpty()) {
            val (stop, distance) = q.removeFirst()
            if (stop == target)
                return distance
            
            stops[stop]?.forEach { bus ->
                routes[bus]?.forEach { nextStop ->
                    if (nextStop !in visit) {
                        visit.add(nextStop)
                        q.addLast(nextStop to (distance + 1))
                    }
                }
                routes[bus]?.clear()
            }
        }

        return -1
    }
}
