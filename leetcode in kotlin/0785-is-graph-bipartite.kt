/*
* BFS
*/
class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val color = IntArray(graph.size)

        fun bfs(start: Int): Boolean {
            val q = LinkedList<Int>()
            q.addFirst(start)
            color[start] = 1

            with (q) {
                while (isNotEmpty()) {
                    val n = removeLast()
                    for (next in graph[n]) {
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
        
        for (i in 0 until graph.size) {
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
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val color = IntArray(graph.size)

        fun dfs(i: Int, c: Int): Boolean {
            color[i] = c

            for (n in graph[i]) {
                if (color[n] == -1 * c) continue
                else if (color[n] == color[i]) return false
                else if (dfs(n, -1 * c) == false) return false
            }
            
            return true
        }
        
        for (i in 0 until graph.size) {
            if (color[i] == 0 && dfs(i, 1) == false)
                return false
        }

        return true
    }
}
