/*
* DFS
*/
class Solution {
    fun countPairs(n: Int, edges: Array<IntArray>): Long {

        val neighbors = HashMap<Int, MutableList<Int>>().apply {
            for ((u, v) in edges) {
                this[u] = getOrDefault(u, mutableListOf<Int>()).apply { this.add(v) }
                this[v] = getOrDefault(v, mutableListOf<Int>()).apply { this.add(u) }
            }
        }

        val visited = BooleanArray(n)
        
        fun dfs(n: Int): Long {
            if (visited[n]) return 0
            visited[n] = true
            var count = 1L
            neighbors[n]?.forEach {
                count += dfs(it)
            }
            return count
        }

        var nodesLeft = n.toLong()
        var res = 0L
        for (i in 0 until n) {
            val count = dfs(i)
            nodesLeft -= count
            res += count * nodesLeft 
        }

        return res
    }
}

/*
* BFS
*/
class Solution {
    fun countPairs(n: Int, edges: Array<IntArray>): Long {

        val neighbors = HashMap<Int, MutableList<Int>>().apply {
            for ((u, v) in edges) {
                this[u] = getOrDefault(u, mutableListOf<Int>()).apply { this.add(v) }
                this[v] = getOrDefault(v, mutableListOf<Int>()).apply { this.add(u) }
            }
        }

        val visited = BooleanArray(n)
        val q = LinkedList<Int>()

        var nodesLeft = n.toLong()
        var res = 0L
        for (i in 0 until n) {
            if (visited[i])
                continue

            visited[i] = true

            var count = 1L
            q.add(i)
            while (q.isNotEmpty()) {
                val n = q.poll()
                neighbors[n]?.forEach {
                    if (!visited[it]) {
                        count++
                        visited[it] = true
                        q.add(it)
                    }
                }
            }
            
            nodesLeft -= count
            res += count * nodesLeft  
        }
        
        return res
    }
}

/*
* Union Find
*/
class Solution {

    class DSU(val n: Int) {
        val parent = IntArray(n) { it }
        val size = IntArray(n) { 1 }

        fun find(x: Int): Int {
            if (parent[x] != x)
                parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int) {
            val px = find(x)
            val py = find(y)
            if (px != py) {
                parent[py] = px
                size[px] += size[py]
            }
        }

        fun getAllComponents(): MutableList<Int> {
            val res = mutableListOf<Int>()
            for (i in 0 until parent.size) {
                if (parent[i] == i)
                    res.add(size[i])
            }
            return res
        }
    }

    fun countPairs(n: Int, edges: Array<IntArray>): Long {

        val neighbors = HashMap<Int, MutableList<Int>>().apply {
            for ((u, v) in edges) {
                this[u] = getOrDefault(u, mutableListOf<Int>()).apply { this.add(v) }
                this[v] = getOrDefault(v, mutableListOf<Int>()).apply { this.add(u) }
            }
        }
    
        val dsu = DSU(n)
        for ((u,v) in edges)
            dsu.union(u, v)

        var nodesLeft = n.toLong()
        var res = 0L
        for (size in dsu.getAllComponents()) {
            nodesLeft -= size
            res += size * nodesLeft 
        }

        return res
    }
}
