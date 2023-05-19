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
