// recursive DFS
class Solution {
    fun restoreArray(adjList: Array<IntArray>): IntArray {
        val adj = HashMap<Int, MutableList<Int>>().apply {
            for ((u, v) in adjList) {
                getOrPut(u) { mutableListOf() }.apply { add(v) }
                getOrPut(v) { mutableListOf() }.apply { add(u) }
            }
        }

        val res = mutableListOf<Int>()
        val visit = HashSet<Int>()
        fun dfs(n: Int) {
            if (n !in visit) {
                visit.add(n)
                res.add(n)
                adj[n]?.forEach {
                    dfs(it)
                }
            }
        }

        var start = -1
        for ((node, list) in adj) {
            if (list.size == 1) {
                start = node
                break
            }
        }

        dfs(start)

        return res.toIntArray()
    }
}
