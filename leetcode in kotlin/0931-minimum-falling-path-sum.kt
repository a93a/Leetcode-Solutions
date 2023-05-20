class Solution {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {

        for (i in 1 until matrix.size) {
            for (j in 0 until matrix.size) {
                matrix[i][j] += minOf(
                    if (j > 0) matrix[i - 1][j - 1] else 10001,
                    matrix[i - 1][j],
                    if (j < matrix.lastIndex) matrix[i - 1][j + 1] else 10001
                )
            }
        }

        return matrix[matrix.lastIndex].min()!!
    }
}
