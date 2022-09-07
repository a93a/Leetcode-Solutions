// DFS with recursion
class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val visited = Array(grid.size){ BooleanArray(grid[0].size) }
        var maxSize = 0
        for(r in 0..grid.size-1){
            for(c in 0..grid[0].size-1){
                if(grid[r][c] == 1)
                    maxSize = maxOf(maxSize, dfs(grid, r, c, visited))
            }
        }  
        return maxSize
    }
    private fun dfs(grid: Array<IntArray>, x: Int, y: Int, visited: Array<BooleanArray>): Int{
        if(!isValid(grid, x, y, visited))
            return 0  
        visited[x][y] = true
        return 1 + dfs(grid, x-1, y, visited) + 
            dfs(grid, x+1, y, visited) + 
            dfs(grid, x, y-1, visited) + 
            dfs(grid, x, y+1, visited)
    }
    private fun isValid(grid: Array<IntArray>, x: Int, y: Int, visited: Array<BooleanArray>) = 
        x >= 0 && y >= 0 && x < grid.size && y < grid[0].size && !visited[x][y] && grid[x][y] == 1
}


//DFS with queue, can change it to BFS by changing queue.poll() and queue.poll() to queue.removeLast() and queue.addLast()
class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val visited = Array(grid.size){ BooleanArray(grid[0].size) }
        var maxSize = 0
        for(r in 0..grid.size-1){
            for(c in 0..grid[0].size-1){
                if(grid[r][c] == 1)
                    maxSize = maxOf(maxSize, dfs(grid, r, c, visited))
            }
        }  
        return maxSize
    }
    private fun dfs(grid: Array<IntArray>, x: Int, y: Int, visited: Array<BooleanArray>): Int{
        if(!isValid(grid, x, y, visited))
            return 0  
        val q = ArrayDeque<Pair<Int,Int>>()
        visited[x][y] = true
        q.add(Pair(x,y))
        var islands = 0
        while(!q.isEmpty()){
            val (curX,curY) = q.poll()
            islands++
            visited[curX][curY] = true
            islands += dfs(grid, curX-1, curY, visited)
            islands += dfs(grid, curX+1, curY, visited)
            islands += dfs(grid, curX, curY-1, visited)
            islands += dfs(grid, curX, curY+1, visited)
        }
        return islands
    }
    private fun isValid(grid: Array<IntArray>, x: Int, y: Int, visited: Array<BooleanArray>) = 
        x >= 0 && y >= 0 && x < grid.size && y < grid[0].size && !visited[x][y] && grid[x][y] == 1
}
