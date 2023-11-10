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

// iterative dfs
class Solution {
    fun restoreArray(adjList: Array<IntArray>): IntArray {
        val adj = HashMap<Int, MutableList<Int>>().apply {
            for ((u, v) in adjList) {
                getOrPut(u) { mutableListOf() }.apply { add(v) }
                getOrPut(v) { mutableListOf() }.apply { add(u) }
            }
        }

        var start = -1
        for ((node, list) in adj) {
            if (list.size == 1) {
                start = node
                break
            }
        }


        val res = mutableListOf(start)
        var cur = start
        var prev = Integer.MAX_VALUE
        while (res.size < adj.size) {
            if (adj[cur] != null) {
                for (nei in adj[cur]!!) {
                    if (nei != prev) {
                        res.add(nei)
                        prev = cur
                        cur = nei
                        break
                    }
                }
            }
        }

        return res.toIntArray()
    }
}
