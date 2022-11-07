class Solution {
    
    val dir = arrayOf(
        intArrayOf(1,0),
        intArrayOf(-1,0),
        intArrayOf(0,1),
        intArrayOf(0,-1)
    )
    
    fun exist(board: Array<CharArray>, word: String): Boolean {
        
        fun isValid(i: Int, j: Int, visited: Array<BooleanArray>) = i in (0 until board.size) && j in (0 until board[0].size) && visited[i][j] == false
        
        fun dfs(i: Int, j: Int, index: Int, visited: Array<BooleanArray>): Boolean {
            if(board[i][j] != word[index] || index == word.length)
                return false
            if(index == word.length-1) // and board[i][j] == word[index] is true here
                return true
            visited[i][j] = true
            var res = false
            for(d in dir){
                val newI = i + d[0]
                val newJ = j + d[1]
                if(isValid(newI, newJ, visited)){
                    res = res or dfs(newI, newJ, index+1, visited)
                }
            }
            // backtracking, if all paths from here gave us false, we set this position as not visited...
            // ...as we might visit it again in another path. See example below
            if(res == false)
                visited[i][j] = false
            return res
        }
        
        for(i in 0 until board.size) {
            for(j in 0 until board[0].size) {
                if(word[0] == board[i][j]) {
                    val visited = Array(board.size) {BooleanArray(board[0].size)}
                    if(dfs(i,j,0, visited) == true)
                        return true
                }
            }
        }
        return false
    }
}

/**
[["A","B","C","E"],
 ["S","F","E","S"],
 ["A","D","E","E"]]

"ABCESEEEFS"
**/
