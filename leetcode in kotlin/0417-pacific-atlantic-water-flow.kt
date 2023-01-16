class Solution {
    val xList = listOf(1,-1,0,0)
    val yList = listOf(0,0,1,-1)
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val pacific = Array(heights.size){ BooleanArray(heights[0].size) }
        val atlantic = Array(heights.size){ BooleanArray(heights[0].size) }
        val result = mutableListOf<List<Int>>()
        for(i in 0..heights.size-1){
            dfs(heights, i, 0, pacific, heights[i][0])
            dfs(heights, i, heights[0].size-1, atlantic, heights[i][heights[0].size-1])
        }
        for(i in 0..heights[0].size-1){
            dfs(heights, 0, i, pacific, heights[0][i])
            dfs(heights, heights.size-1, i, atlantic, heights[heights.size-1][i])
        }
        for(r in 0..heights.size-1){
            for(c in 0..heights[0].size-1){
                if(pacific[r][c] == true && atlantic[r][c]==true)
                    result.add(listOf(r,c))
            }
        }       
        return result
    }
    private fun dfs(heights: Array<IntArray>, x: Int, y: Int, reached: Array<BooleanArray>, prevHeight: Int){
        if(!isValid(heights, x, y, reached, prevHeight))
            return
        reached[x][y] = true
        for(i in 0..3)
            dfs(heights, x+xList[i], y+yList[i], reached,heights[x][y])  
    }
    private fun isValid(heights: Array<IntArray>, x: Int, y: Int, reached: Array<BooleanArray>, prevHeight: Int) = 
        x >= 0 && y >= 0 && x < heights.size && y < heights[0].size && !reached[x][y] && heights[x][y] >= prevHeight
}
