//DP solution
class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        val d = Array (m) { IntArray (n) { (m * n) } } 

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mat[i][j] == 0) {
                    d[i][j] = 0
                } else {
                    if (i > 0)
                        d[i][j] = minOf(d[i][j], d[i - 1][j] + 1)
                    if (j > 0) 
                        d[i][j] = minOf(d[i][j], d[i][j - 1] + 1)
                }
            }      
        }

        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                if (i < m - 1)
                    d[i][j] = minOf(d[i][j], d[i + 1][j] + 1)
                if (j < n - 1) 
                    d[i][j] = minOf(d[i][j], d[i][j + 1] + 1)
            }      
        }

        return d
    } 
}

//BFS solution
class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        val q = ArrayDeque<Pair<Int,Int>>()
        val direction = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0 ,1),
            intArrayOf(-1, 0),
            intArrayOf(0, -1))

        fun isValid(x: Int, y: Int) = x in (0 until m) && y in (0 until n)
        
        for (i in 0..mat.size-1) {
            for (j in 0..mat[0].size-1) {
                if (mat[i][j] == 0)
                    q.add(i to j)
                else
                    mat[i][j] = Integer.MAX_VALUE
            }      
        }

        while (q.isNotEmpty()) {
            val (x,y) = q.poll()
            for (dir in direction) {
                val newX = x + dir[0]
                val newY = y + dir[1]
                if (isValid(newX, newY)) {
                    if (mat[newX][newY] <= mat[x][y] + 1) 
                        continue
                    mat[newX][newY] = mat[x][y] + 1 
                    q.add(newX to newY)
                }
            }
        }

        return mat
    } 
}
