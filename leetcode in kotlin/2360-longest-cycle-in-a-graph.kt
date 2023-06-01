class Solution {
    fun longestCycle(edges: IntArray): Int {
        val visited = BooleanArray(edges.size)
       
        var res = -1
        for (i in 0 until edges.size) {
            if (!visited[i]) {
                var j = i
                var len = 0
                val visitAtLen = HashMap<Int, Int>()

                while (edges[j] != -1) {
                    visitAtLen[j]?.let {
                        res = maxOf(
                            res,
                            len - visitAtLen[j]!!
                        )
                    }

                    if (visited[j]) break

                    visited[j] = true
                    visitAtLen.put(j, len++)
                    j = edges[j]
                }
            }
        }

        return res
    }
}
