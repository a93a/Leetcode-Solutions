class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val row = matrix.size-1; val col = matrix[0].size-1; var rowZero = 1
        for(i in 0..row){
            for(j in 0..col){
                if(matrix[i][j]==0){
                    matrix[0][j] = 0
                    if(i > 0) 
                        matrix[i][0] = 0
                    else 
                        rowZero = 0
                }
            }
        }
        for(i in 1..row){
            for(j in 1..col){
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0
            }
        }
        if(matrix[0][0] == 0){
            for(i in 0..row)
                matrix[i][0] = 0
        }
        if(rowZero == 0){
            for(i in 0..col)
                matrix[0][i] = 0
        }
    }
}
