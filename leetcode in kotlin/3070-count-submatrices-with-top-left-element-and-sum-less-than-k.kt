class Solution {
    fun countSubmatrices(g: Array<IntArray>, k: Int): Int {
        var res = 0

        for (i in 0 until g.size) {
            for (j in 0 until g[0].size) {
                if (i > 0)
                    g[i][j] += g[i - 1][j]
                if (j > 0)
                    g[i][j] += g[i][j - 1]
                if (i > 0 && j > 0)
                    g[i][j] -= g[i - 1][j - 1]
                if (g[i][j] <= k)
                    res++
            }
        }

        return res
    }
}
