class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val lp = Array(matrix.size){IntArray(matrix[0].size)}
        var max = 1 //in any case our max will always be 1 per definition of the problem
        for(i in 0 until matrix.size){
            for(j in 0 until matrix[0].size){
                max = maxOf(max, dfs(i, j, Int.MIN_VALUE, lp, matrix))
            }
        }
        return max
    }
    private fun dfs(
        i: Int, 
        j: Int, 
        prev: Int, 
        lp: Array<IntArray>, 
        m: Array<IntArray>
    ): Int{
        if(!isValid(i, j, m) || prev >= m[i][j])
            return 0
        if(lp[i][j] > 0)
            return lp[i][j]
        lp[i][j] = 1
        for(c in cord)
            lp[i][j] = maxOf(lp[i][j], 1 + dfs(i+c[0], j+c[1], m[i][j], lp, m))
        return lp[i][j]
    }
    private fun isValid(i: Int, j: Int, m: Array<IntArray>) = 
        i >= 0 && j >= 0 && i < m.size && j < m[0].size
    
    val cord = arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1))
}
