class Solution {
    fun minimumOperationsToWriteY(g: Array<IntArray>): Int {
        val n = g.size
        
        fun count(a: Int, b: Int): Int {
            var res = 0

            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (i <= n / 2 && (i == j || i + j == n - 1)) {
                        if (a != g[i][j]) res++
                    } else if (i > n / 2 && j == n / 2) {
                        if (a != g[i][j]) res++
                    } else {
                        if (b != g[i][j]) res++
                    }
                }
            }

            return res
        }

        var res = Integer.MAX_VALUE
        val nums = intArrayOf(0, 1, 0, 2, 1, 2, 0)
        for (i in 0 until 6) {
            res = minOf(res, count(nums[i], nums[i + 1]))
        }

        return res
    }
}
