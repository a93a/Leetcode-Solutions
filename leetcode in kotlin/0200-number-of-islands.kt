//using BFS without queue
class Solution {    
    fun numIslands(grid: Array<CharArray>): Int {
        if(grid.size == 0)
            return 0
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }
        var noOfIslands = 0
        for(r in 0..grid.size-1){
            for(c in 0..grid[0].size-1){
                if(grid[r][c]=='1' && !visited[r][c]){
                    bfs(grid,r,c, visited)
                    noOfIslands++
                }
            }
        }      
        return noOfIslands
    }
    private fun bfs(grid: Array<CharArray>, r: Int, c: Int, visited: Array<BooleanArray>) {
        visited[r][c] == true
        val xCords = intArrayOf(0, 0, -1, 1)
        val yCords = intArrayOf(-1, 1, 0, 0)
        for(i in 0..3){
            val newX = r+xCords[i]
            val newY = c+yCords[i]
            if(isValid(grid, newX, newY, visited)){
                visited[newX][newY] = true
                bfs(grid,newX ,newY, visited)
            }
        }    
    }
    private fun isValid(grid: Array<CharArray>, x: Int, y: Int, visited: Array<BooleanArray>) 
        = (x >= 0 && y >= 0 && x < grid.size && y < grid[0].size && grid[x][y] == '1' && !visited[x][y])
}


//using BFS with queue
class Solution {    
    fun numIslands(grid: Array<CharArray>): Int {
        if(grid.size == 0)
            return 0
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }
        var noOfIslands = 0
        for(r in 0..grid.size-1){
            for(c in 0..grid[0].size-1){
                if(grid[r][c]=='1' && !visited[r][c]){
                    bfs(grid,r,c, visited)
                    noOfIslands++
                }
            }
        }      
        return noOfIslands
    }
    private fun bfs(grid: Array<CharArray>, r: Int, c: Int, visited: Array<BooleanArray>) {
        val q = ArrayDeque<Pair<Int,Int>>()
        visited[r][c] == true
        q.add(Pair(r,c))
        while(!q.isEmpty()){
            val (x,y) = q.poll()
            val xCords = intArrayOf(0, 0, -1, 1)
            val yCords = intArrayOf(-1, 1, 0, 0)
            for(i in 0..3){
                val newX = x+xCords[i]
                val newY = y+yCords[i]
                if(isValid(grid, newX, newY, visited)){
                    q.add(Pair(newX,newY))
                    visited[newX][newY] = true
                }
            }
        }     
    }
    private fun isValid(grid: Array<CharArray>, x: Int, y: Int, visited: Array<BooleanArray>) 
        = (x >= 0 && y >= 0 && x < grid.size && y < grid[0].size && grid[x][y] == '1' && !visited[x][y])
}

//Using the Queue solution but implementing DFS by using the queue as a stack
class Solution {    
    fun numIslands(grid: Array<CharArray>): Int {
        if(grid.size == 0)
            return 0
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }
        var noOfIslands = 0
        for(r in 0..grid.size-1){
            for(c in 0..grid[0].size-1){
                if(grid[r][c]=='1' && !visited[r][c]){
                    bfs(grid,r,c, visited)
                    noOfIslands++
                }
            }
        }      
        return noOfIslands
    }
    private fun bfs(grid: Array<CharArray>, r: Int, c: Int, visited: Array<BooleanArray>) {
        val q = ArrayDeque<Pair<Int,Int>>()
        visited[r][c] == true
        q.addLast(Pair(r,c))
        while(!q.isEmpty()){
            val (x,y) = q.removeLast()
            val xCords = intArrayOf(0, 0, -1, 1)
            val yCords = intArrayOf(-1, 1, 0, 0)
            for(i in 0..3){
                val newX = x+xCords[i]
                val newY = y+yCords[i]
                if(isValid(grid, newX, newY, visited)){
                    q.addLast(Pair(newX,newY))
                    visited[newX][newY] = true
                }
            }
        }     
    }
    private fun isValid(grid: Array<CharArray>, x: Int, y: Int, visited: Array<BooleanArray>) 
        = (x >= 0 && y >= 0 && x < grid.size && y < grid[0].size && grid[x][y] == '1' && !visited[x][y])
}

//using DFS with recursion
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        if(grid.size == 0)
            return 0
        var noOfIslands = 0
        for(r in 0..grid.size-1){
            for(c in 0..grid[0].size-1){
                if(grid[r][c]=='1'){
                    dfs(grid,r,c)
                    noOfIslands++
                }
            }
        }      
        return noOfIslands
    }
    private fun dfs(grid: Array<CharArray>, r: Int, c: Int) {
        if(r < 0 || c < 0 || r > grid.size-1 || c > grid[0].size-1 || grid[r][c] == '0')
            return
        grid[r][c] = '0'
        dfs(grid,r+1,c)
        dfs(grid,r,c+1)
        dfs(grid,r-1,c)
        dfs(grid,r,c-1)
    }
}
