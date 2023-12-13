class Solution {
    fun numSpecial(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        val rows = IntArray (m)
        val cols = IntArray (n)

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mat[i][j] == 1) {
                    rows[i] += 1
                    cols[j] += 1
                }
            }
        }

        var res = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1)
                    res++
            }
        }

        return res
    }
}
