class Solution {
    fun distanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>, _queries: Array<IntArray>): BooleanArray {
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

        edgeList.sortBy {it[2]}

        val queries = _queries.mapIndexed {
            i, q -> intArrayOf(q[0], q[1], q[2], i)
        }.toTypedArray()
        queries.sortBy {it[2]}

        val res = BooleanArray(queries.size)

        var i = 0
        for ((u, v, l, j) in queries) {
            while (i < edgeList.size && edgeList[i][2] < l) {
                union(edgeList[i][0], edgeList[i][1])
                i += 1
            }

            res[j] = find(u) == find(v)
        }

        return res
    }
}
