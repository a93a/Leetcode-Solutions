class Solution {
    fun minimumMoves(grid: Array<IntArray>): Int {

        fun isSaturated() : Boolean {
            for (i in 0..2) {
                for (j in 0..2) {
                    if (grid[i][j] != 1)
                        return false
                }
            }
            return true
        }

        fun backtrack(): Int {
            if (isSaturated()) return 0

            var res = 9999
            for (i in 0..2) {
                for (j in 0..2) {
                    if (grid[i][j] == 0) {
                        for (i2 in 0..2) {
                            for (j2 in 0..2) {
                                if (grid[i2][j2] > 1) {
                                    grid[i2][j2]--
                                    grid[i][j]++
                                    val dist = Math.abs(i - i2) + Math.abs(j - j2)
                                    res = minOf(res, dist + backtrack())
                                    grid[i2][j2]++
                                    grid[i][j]--
                                }
                            }
                        }       
                    }
                }
            }

            return res
        }

        return backtrack()
    }
}
