// variant 1 iterate the matrix once for maxes that are kept in an array, iterate second time to build new matrix
class Solution {
    fun modifiedMatrix(g: Array<IntArray>): Array<IntArray> {
        val m = g.size
        val n = g[0].size
        val max = IntArray (n)

        for (i in 0 until m) {
            for (j in 0 until n)
                max[j] = maxOf(max[j], g[i][j])
        }

        var res = Array (m) { IntArray (n) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                res[i][j] = if (g[i][j] == -1) max[j] else g[i][j]
            }
        }

        return res
    }
}

// variant 2 iterate matrix once columnwise, get column max and replace all negative ones
class Solution {
    fun modifiedMatrix(g: Array<IntArray>): Array<IntArray> {
        for (j in 0 until g[0].size) {
            var max = -1
            for (i in 0 until g.size)
                max = maxOf(max, g[i][j])
            for (i in 0 until g.size)
                g[i][j] = if (g[i][j] == -1) max else g[i][j]
        }
        return g
    }
}
