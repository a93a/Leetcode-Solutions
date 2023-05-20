class Solution {
    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        val dir = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )
        val visited = Array (grid.size) { Array (grid[0].size) { BooleanArray(k + 1) } }

        fun isValid(i: Int, j: Int) = i in (0..grid.lastIndex) && j in (0..grid[0].lastIndex)
    
        with (LinkedList<IntArray>()) {
            addLast(intArrayOf(0, 0, k, 0))
            visited[0][0][k] = true

            while (isNotEmpty()) {
                val (i, j, obsLeft, len) = removeFirst()

                if (i == grid.lastIndex && j == grid[0].lastIndex) 
                    return len

                for (d in dir) {
                    val iNxt = i + d[0]
                    val jNxt = j + d[1]
                    if (isValid(iNxt, jNxt)) {
                        if (obsLeft > 0 && grid[iNxt][jNxt] == 1 && !visited[iNxt][jNxt][obsLeft - 1]) {
                            addLast(intArrayOf(iNxt, jNxt, obsLeft - 1, len + 1))
                            visited[iNxt][jNxt][obsLeft - 1] = true
                        } else if (grid[iNxt][jNxt] == 0 && !visited[iNxt][jNxt][obsLeft]) {
                            addLast(intArrayOf(iNxt, jNxt, obsLeft, len + 1))
                            visited[iNxt][jNxt][obsLeft] = true
                        }   
                    }
                }
            }
        }

        return -1
    }
}
