class Solution {
    fun countNegatives(g: Array<IntArray>): Int {
        val m = g.lastIndex
        val n = g[0].lastIndex
        var row = m
        var col = 0
        var res = 0

        while (row >= 0 && col <= n) {
            if (g[row][col] >= 0 ) {
                col++
            } else {
                res += (n - col + 1)
                row--
            }
        }

        return res
    }
}
