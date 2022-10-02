//DP solution
class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val dist = Array(mat.size){ IntArray(mat[0].size){ (mat.size * mat[0].size) } } //cant use Integer.MAX_VALUE, will use value outside of possible range of distance
        for(i in 0 until mat.size){ //left and top
            for(j in 0 until mat[0].size){
                if(mat[i][j] == 0){
                    dist[i][j] = 0
                }else{
                    if(i > 0)
                        dist[i][j] = minOf(dist[i][j], dist[i-1][j] + 1)
                    if(j > 0) 
                        dist[i][j] = minOf(dist[i][j], dist[i][j-1] + 1)
                }
            }      
        }
        for(i in mat.size-1 downTo 0){ // bottom and right
            for(j in mat[0].size-1 downTo 0){
                if(i < mat.size-1)
                    dist[i][j] = minOf(dist[i][j], dist[i+1][j] + 1)
                if(j < mat[0].size-1) 
                    dist[i][j] = minOf(dist[i][j], dist[i][j+1] + 1)
            }      
        }
        return dist
    } 
}


//BFS solution
class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val q = ArrayDeque<Pair<Int,Int>>()
        val direction = arrayOf(
            intArrayOf(1,0),
            intArrayOf(0,1),
            intArrayOf(-1,0),
            intArrayOf(0,-1))
        for(i in 0..mat.size-1){
            for(j in 0..mat[0].size-1){
                if(mat[i][j] == 0) // BFS over "0"s
                    q.add(Pair(i,j))
                else
                    mat[i][j] = Integer.MAX_VALUE
            }      
        }
        while(!q.isEmpty()){
            val (x,y) = q.poll()
            for(dir in direction){
                val newX = x+dir[0]
                val newY = y+dir[1]
                if(isValid(newX,newY,mat)){
                    if(mat[newX][newY] <= mat[x][y]+1) //if neighbour is not a unvisited "1"
                        continue
                    //else
                    mat[newX][newY] = mat[x][y]+1 // set the "1"s distance
                    q.add(Pair(newX,newY))
                }  
            }
        }    
        return mat
    } 
    private fun isValid(
        x: Int, 
        y: Int, 
        mat: Array<IntArray>
    ) = x >= 0 && y >= 0 && x < mat.size && y < mat[0].size
}
