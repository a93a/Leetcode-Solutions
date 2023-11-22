class Solution {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val m = mat.size
        val n = mat[0].size
        val maxDia = m + n - 1
        val diagonals = HashMap<Int, MutableList<Int>>()

        for (i in 0 until m) {
            for (j in 0 until n) {
                diagonals.getOrPut(i + j) { mutableListOf<Int>() }.apply { add(mat[i][j]) }
            }
        }

        val res = IntArray (m * n)
        var i = 0
        for (d in 0..maxDia) {
            diagonals[d]?.let { list ->
                if (d % 2 == 1) {
                    for (j in 0 until list.size) 
                        res[i++] = list[j]
                } else {
                    for (j in list.lastIndex downTo 0) 
                        res[i++] = list[j]
                }
            } 
        }

        return res
    }
}
