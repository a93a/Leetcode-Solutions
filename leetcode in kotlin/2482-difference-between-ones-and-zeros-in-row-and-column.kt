class Solution {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
       
        val rowSum = IntArray(grid.size)
        val colSum = IntArray(grid[0].size)
        val res = Array(grid.size) { IntArray(grid[0].size) }

        for(i in grid.indices) {
            for(j in grid[0].indices) {
                rowSum[i] += grid[i][j] * 2 - 1
                colSum[j] += grid[i][j] * 2 - 1
            }
        }

        for(i in grid.indices) {
            for(j in grid[0].indices) {
                res[i][j] = rowSum[i] + colSum[j]
            }
        }

        return res
    }
}
