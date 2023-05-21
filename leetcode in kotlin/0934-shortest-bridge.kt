class Solution {
    fun shortestBridge(grid: Array<IntArray>): Int {
        val q = LinkedList<IntArray>()

        val dir = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        fun isValid(i: Int, j: Int) = i in (0..grid.lastIndex) && j in (0..grid[0].lastIndex)

        fun isNextToWater(i: Int, j: Int): Boolean {
            for (d in dir) {
                val iN = i + d[0]
                val jN = j + d[1]
                if (isValid(iN, jN) && grid[iN][jN] == 0)
                    return true
            }
            return false
        }

        fun dfs(i: Int, j: Int) {
            if (isNextToWater(i, j))
                q.addLast(intArrayOf(i, j, 0))
            grid[i][j] = -1

            for (d in dir) {
                val iN = i + d[0]
                val jN = j + d[1]
                if (isValid(iN, jN) && grid[iN][jN] == 1) {
                    grid[iN][jN] = -1
                    dfs(iN, jN)
                }
            }
        }

        outer@for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 1) {
                    dfs(i, j)
                    break@outer
                }
            }
        }

        with (q) {
            while (isNotEmpty()) {
                val (i, j, len) = removeFirst()

                for (d in dir) {
                    val iN = i + d[0]
                    val jN = j + d[1]
                    if (isValid(iN, jN)) {
                        if (grid[iN][jN] == 1) {
                            return len
                        } else if (grid[iN][jN] == 0) {
                            addLast(intArrayOf(iN, jN, len + 1))
                            grid[iN][jN] = -1
                        }
                    }        
                }
            }
        }

        return -1
    }
}
