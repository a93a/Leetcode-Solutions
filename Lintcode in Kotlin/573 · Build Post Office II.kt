class Solution {
    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    fun shortestDistance(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val timesVisited = Array(m) { IntArray(n) }
        val distance = Array(m) { IntArray(n) }
        val dir = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )
        
        fun isValid(i: Int, j: Int) = i in (0 until m) && j in (0 until n) && grid[i][j] == 0

        fun bfs(i: Int, j: Int) {
            val visited = Array(m) { BooleanArray(n) }
            val q = ArrayDeque<IntArray>() // array [x,y,distance]

            q.add(intArrayOf(i, j, 0))
            visited[i][j] = true

            while (q.isNotEmpty()) {
                val qSize = q.size
                repeat (qSize) {
                    val (x,y,dis) = q.poll()
                    distance[x][y] += dis
                    timesVisited[x][y] += 1

                    for (d in dir) {
                        val nX = x + d[0]
                        val nY = y + d[1]
                        if (isValid(nX, nY) && visited[nX][nY] == false) {
                            q.add(intArrayOf(nX, nY, dis+1))
                            visited[nX][nY] = true
                        }  
                    }
                }
            }
        }

        var noOfHouses = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    noOfHouses++
                    bfs(i,j)
                }    
            }
        }

        var min = Integer.MAX_VALUE
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0 && timesVisited[i][j]==noOfHouses)
                    min = minOf(min, distance[i][j])
            }
        }

        return if (min == Integer.MAX_VALUE) -1 else min
    }
}
