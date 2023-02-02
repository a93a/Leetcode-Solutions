class Solution {
    fun solveNQueens(n: Int): List<List<String>> {

        val cols = HashSet<Int>() 
        val posDia = HashSet<Int>() 
        val negDia = HashSet<Int>() 
        val board =  ArrayList<ArrayList<String>>() 
        val res = ArrayList<ArrayList<String>>() 

        fun fillWithQueens(row: Int){
        
            if(row == n){
                val complete = ArrayList<String>()
                for(i in 0..n-1){
                    val joined = board[i].joinToString(separator = "")
                    complete.add(joined)
                }
                res.add(complete)
                return
            }

            for(column in 0 until n){
                if(cols.contains(column) || posDia.contains(row+column) || negDia.contains(row-column)) continue

                val temp = tempRow(n)
                board.add(temp)

                cols.add(column)
                posDia.add(row+column)
                negDia.add(row-column)
                board[row][column] = "Q"

                fillWithQueens(row+1)

                cols.remove(column)
                posDia.remove(row+column)
                negDia.remove(row-column)
                board[row][column] = "."
            }
        }

        fillWithQueens(0)
        return res
    }
    
    fun tempRow(n: Int): ArrayList<String>{
        val temp = ArrayList<String>()
        repeat(n){ temp.add(".") }
        return temp
    }
}
