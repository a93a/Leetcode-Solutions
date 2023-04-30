/*
* Union-Find solution
*/
class Solution {
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if(connections.size < n - 1) return -1

        val parent = IntArray(n) {it}

        fun find(x: Int): Int {
            if (parent[x] != x)
                parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int) {
            val pX = find(x)
            val pY = find(y)
            if (pX != pY)
                parent[pY] = pX
        }

        for ((x,y) in connections)
            union(x, y)

        var res = 0
        for (i in 0 until n) {
            if (find(i) == i)
                res += 1
        }
        
        return res - 1
    }
}

/*
* DFS solution
*/
class Solution {
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if(connections.size < n - 1) return -1

        val verticies = HashMap<Int, HashSet<Int>>()
        for (c in connections) {
            verticies[c[0]] = verticies.getOrDefault(c[0], HashSet<Int>()).apply { this.add(c[1]) }
            verticies[c[1]] = verticies.getOrDefault(c[1], HashSet<Int>()).apply { this.add(c[0]) }
        }

        val visited = HashSet<Int>()

        fun dfs(i: Int) {
            visited.add(i)
            verticies[i]?.forEach {
                if (!visited.contains(it))
                    dfs(it)
            }
        }

        var networks = 0

        (0..n-1).forEach { 
            if (!visited.contains(it!!)) {
                dfs(it!!) 
                networks++
            }
        }

        return networks - 1
    }
}
