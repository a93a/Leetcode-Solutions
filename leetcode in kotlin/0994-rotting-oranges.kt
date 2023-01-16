class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var mins = 0; var fresh = 0
        val xCord = arrayOf(1,-1,0,0)
        val yCord = arrayOf(0,0,1,-1)
        val q = ArrayDeque<Pair<Int, Int>>()
        for(r in 0..grid.size-1){
            for(c in 0..grid[0].size-1){
                if(grid[r][c] == 1)
                    fresh++
                if(grid[r][c] == 2)
                    q.add(Pair(r,c))
            }
        }
        while(!q.isEmpty() && fresh > 0){
            //we iterate all the positions that were added at time x
            repeat(q.size){
                val (x,y) = q.poll()
                for(i in 0..3){
                    val nextX = x+xCord[i]; val nextY = y+yCord[i]
                    if(isValid(grid, nextX, nextY)){
                        grid[nextX][nextY] = 2
                        q.add(Pair(nextX, nextY))
                        fresh--
                    }
                }
            }
            mins++
        }
        //did we miss some oranges that were unreachable ?
        return if(fresh == 0) mins else -1
    }
    private fun isValid(grid: Array<IntArray>, r: Int, c: Int) =
        r >= 0 && c >= 0 && r < grid.size && c < grid[0].size && grid[r][c] == 1
}
