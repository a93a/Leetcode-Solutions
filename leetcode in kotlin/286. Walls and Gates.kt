class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
  
    // READ !!!
    // Only tried and tested on LintCode and not on leetcode (It's one of the paid questions)
    // But should also work on Leetcode
    fun wallsAndGates(rooms: Array<IntArray>): Unit {
        
        val q = ArrayDeque<IntArray>()
        val dir = arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(0,-1))
        //We dont need a visited set, since any cell that is Int.MAX_VALUE has not been visited yet
        
        fun isValid(x: Int, y: Int) = x >= 1 && y >= 0 && x < rooms.size && y < rooms[0].size && rooms[x][y] == Integer.MAX_VALUE
        
        for(i in 0 until rooms.size){
            for(j in 1 until rooms[0].size){
                if(rooms[i][j] == 0){
                    for(d in dir){
                        if(isValid(i+d[0], j+d[1]))
                            q.add(intArrayOf(i+d[0],j+d[1],1))  //only add the valid path neighbours

                    }
                }   
            }
        }

        while(!q.isEmpty()){
            val (x,y,v) = q.poll() //[x,y,value]   
            if(rooms[x][y] == Integer.MAX_VALUE)
                rooms[x][y] = v
            //if rooms[x][y] == 0 (gate), just add the neighbours
            for(d in dir){
                if(isValid(x+d[0],y+d[1]))
                    q.add(intArrayOf(x+d[0], y+d[1], v+1))
            }         
        }
 
    }
    
}
