class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val grid = Array<IntArray>(m){ IntArray(n) }
        for(i in 0..m-1)
            grid[i][0] = 1
        for(j in 0..n-1)
            grid[0][j] = 1
        for(i in 1..m-1){
            for(j in 1..n-1)
                grid[i][j] = grid[i-1][j] + grid[i][j-1]
        }
        return grid[m-1][n-1]
    }
}
