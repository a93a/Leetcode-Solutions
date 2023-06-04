class Solution {
    fun matrixSumQueries(n: Int, q: Array<IntArray>): Long {
        val row = BooleanArray(n)
        val col = BooleanArray(n)
        var rowCount = n
        var colCount = n 

        var res = 0L
        for (i in q.lastIndex downTo 0) {
            val (t, i, v) = q[i]
            when (t) {
                0 -> {
                    if (!row[i]) {
                        res += v * colCount
                        row[i] = true
                        rowCount--
                    }
                }
                1 -> {
                    if (!col[i]) {
                        res += v * rowCount
                        col[i] = true
                        colCount--
                    }
                }
            }
        }
        
        return res
    }
}
