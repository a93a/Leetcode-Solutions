class Solution {
    fun exist(b: Array<CharArray>, w: String): Boolean {
        val m = b.size
        val n = b[0].size
        val dir = intArrayOf(0, 1, 0, -1, 0)

        fun dfs(i: Int, j: Int, k: Int): Boolean {
            if (k == w.lastIndex) return if (b[i][j] == w[k]) true else false
            if (b[i][j] != w[k]) return false

            val temp = b[i][j]
            b[i][j] = '@'

            for (d in 0..3) {
                val ni = i + dir[d]
                val nj = j + dir[d + 1]
                if (ni in 0 until m && nj in 0 until n && b[ni][nj] != '@') {
                    if (dfs(ni, nj, k + 1)) return true
                }
            }

            b[i][j] = temp

            return false
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (dfs(i, j, 0)) return true
            }
        }

        return false
    }
}
