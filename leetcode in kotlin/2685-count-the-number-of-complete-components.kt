/*
* DFS
*/
class Solution {
    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        val adj = HashMap<Int, ArrayList<Int>>().apply {
            for ((u, v) in edges) {
                this[u] = getOrDefault(u, arrayListOf()).apply { add(v) }
                this[v] = getOrDefault(v, arrayListOf()).apply { add(u) }
            }
        }

        val visited = BooleanArray(n)

        fun bfs(i: Int): Pair<Int, Int> {
            if (visited[i])
                return 0 to 0

            visited[i] = true

            var nodes = 1
            var edges = (adj[i]?.size?: 0)
            adj[i]?.forEach {
                val (nodes2, edges2) = bfs(it)
                nodes += nodes2
                edges += edges2
            }

            return nodes to edges
        }

        var res = 0
        for (i in 0 until n) {
            if (!visited[i]) {
                val (nodes, edges) = bfs(i)
                if ((nodes * (nodes - 1)) == edges)
                    res++
            }
        }

        return res
    }
}

/*
* Union Find
*/
class Solution {
    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        val dsu = DSU(n)

        for ((u, v) in edges)
            dsu.union(u, v)

        var res = 0
        for (i in 0 until n) {
            val size = dsu.size[dsu.find(i)]
            if ((size * (size - 1) / 2) == dsu.edges[i])
                res++
        }

        return res
    }
    
    class DSU(val n: Int) {
        val parent = IntArray(n) { it }
        val size = IntArray(n) { 1 }
        val edges = IntArray(n)

        fun find(x: Int): Int {
            if (x != parent[x])
                parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int) {
            val px = find(x)
            val py = find(y)
            edges[px]++

            if (px != py) {
                parent[py] = px
                edges[px] += edges[py]
                size[px] += size[py]
            }
        }
    }
}
