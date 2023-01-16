class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        var matrix = Array(text1.length+1){Array(text2.length+1){0}}
        for(i in text1.length-1 downTo 0){
            for(j in text2.length-1 downTo 0){
                if(text1[i] == text2[j]){
                    matrix[i][j] = 1 + matrix[i+1][j+1]
                }else
                    matrix[i][j] = maxOf(matrix[i+1][j],matrix[i][j+1])
            }
        }
        return matrix[0][0]
    }
}
