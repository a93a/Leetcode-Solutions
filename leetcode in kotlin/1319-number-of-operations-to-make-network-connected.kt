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
