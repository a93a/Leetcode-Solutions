class Solution {
    fun solve(board: Array<CharArray>): Unit {
        val r = board.size-1; val c = board[0].size-1
        for(x in 0..r){
            if(board[x][0]=='O' )
                dfs(board, x, 0)
            if(board[x][c]=='O')
                dfs(board, x, c)
        }
        for(x in 0..c){
            if(board[0][x]=='O' )
                dfs(board, 0, x)
            if(board[r][x]=='O')
                dfs(board, r, x) 
        }
        for(x in 0..r){
            for(y in 0..c){
                if(board[x][y] == 'O')
                    board[x][y] = 'X'
                else if(board[x][y] == 'T')
                    board[x][y] = 'O'
            }
        }
    }
    private fun dfs(board: Array<CharArray>, r: Int, c: Int){
        if(!isValid(board, r, c))
            return
        board[r][c] = 'T'
        dfs(board, r+1 ,c)
        dfs(board, r-1 ,c)
        dfs(board, r ,c+1)
        dfs(board, r ,c-1)
        return
    }
    private fun isValid(board: Array<CharArray>, r: Int, c: Int) = 
        r >= 0 && c >= 0 && r < board.size && c < board[0].size && board[r][c] == 'O'
}
