class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {       
        val res = ArrayList<Int>()
        var left = 0; var right = matrix[0].size-1; var top = 0; var bot = matrix.size-1           
        while(left <= right && top <= bot){           
            //top row
            for(i in left..right)
                res.add(matrix[top][i])
            top++   
            //right column
            for(i in top..bot)
                res.add(matrix[i][right])
            right--  
            if(left > right || top > bot)// dont continue if these values "overlap"
               break         
            //bottom row
            for(i in right downTo left)
                res.add(matrix[bot][i])
            bot--          
            //left column
            for(i in bot downTo top)
                res.add(matrix[i][left])
            left++
        }                   
        return res
    }
}
