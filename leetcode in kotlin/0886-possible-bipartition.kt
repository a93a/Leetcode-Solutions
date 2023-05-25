/*
* Union Find
*/
class Solution {

    class DSU(val n: Int) {
        val parent = IntArray(n) { it }

        fun find(x: Int): Int {
            if (x != parent[x])
                parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int): Boolean {
            val px = find(x)
            val py = find(y)
            if (px == py)
                return false
            parent[py] = px
            return true
        }
    }

    fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
        val dsu = DSU(n + 1)
        val adj = Array (n + 1) { arrayListOf<Int>()}

        for ((u, v) in dislikes) {
            adj[u].add(v)
            adj[v].add(u)
        }

        for (i in 1..n) {
            for (j in adj[i]) {
                if (dsu.find(i) == dsu.find(j))
                    return false
                dsu.union(adj[i][0], j)
            }
        } 

        return true
    }
}

/*
* BFS
*/
class Solution {
    fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
        val adj = Array (n + 1) { arrayListOf<Int>()}
        val color = IntArray(n + 1)

        for ((u, v) in dislikes) {
            adj[u].add(v)
            adj[v].add(u)
        }

        fun bfs(start: Int): Boolean {
            val q = LinkedList<Int>()
            q.addFirst(start)
            color[start] = 1

            with (q) {
                while (isNotEmpty()) {
                    val n = removeLast()
                    for (next in adj[n]) {
                        if (color[next] == color[n]) {
                            return false
                        } else if (color[next] == 0) {
                            color[next] = -1 * color[n]
                            addFirst(next)
                        }
                    }
                }
            }

            return true
        }

        for (i in 1..n) {
            if (color[i] == 0 && bfs(i) == false)
                return false
        }

        return true
    }
}

/*
* DFS
*/
class Solution {
    fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
        val adj = Array (n + 1) { arrayListOf<Int>()}
        val color = IntArray(n + 1)

        for ((u, v) in dislikes) {
            adj[u].add(v)
            adj[v].add(u)
        }

        fun dfs(i: Int, c: Int): Boolean {
            color[i] = c

            for (n in adj[i]) {
                if (color[n] == -1 * c) continue
                else if (color[n] == color[i]) return false
                else if (dfs(n, -1 * c) == false) return false
            }
            
            return true
        }


        for (i in 1..n) {
            if (color[i] == 0 && dfs(i, 1) == false)
                return false
        }

        return true
    }
}
