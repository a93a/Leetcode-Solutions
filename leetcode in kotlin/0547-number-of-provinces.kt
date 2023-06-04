class Solution {
    fun findCircleNum(c: Array<IntArray>): Int {
        val n = c.size
        val parent = IntArray (n) { it }
        val size = IntArray (n) { 1 }

        fun find(x: Int): Int {
            if (x != parent[x])
                parent[x] = find(parent[x])
            return parent[x]
        } 

        fun union(x: Int, y: Int): Boolean {
            val px = find(x)
            val py = find(y)
            if (px != py) {
                if (size[px] > size[py]) {
                    parent[py] = px
                    size[px] += size[py]
                } else {
                    parent[px] = py
                    size[py] += size[px]
                }
                return true
            }
            return false
        }

        var u = 0
        for (x in 0 until n) {
            for (y in 0 until n) {
                if (x == y) continue
                if (c[x][y] == 1) {
                    if (union(x, y)) {
                        u++
                    }
                }
            }
        }

        return n - u
    }
}
