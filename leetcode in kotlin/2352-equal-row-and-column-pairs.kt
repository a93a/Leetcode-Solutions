class Solution {
    fun equalPairs(g: Array<IntArray>): Int {
        val n = g.size
        val rows = HashMap<String, Int>()

        for (i in 0 until n) {
            val sb = StringBuilder()
            for (j in 0 until n) {
                sb.append(g[i][j])
                sb.append(":")
            }
            val key = sb.toString()
            rows[key] = rows.getOrDefault(key, 0) + 1
        }

        var res = 0
        for (i in 0 until n) {
            val sb = StringBuilder()
            for (j in 0 until n) {
                sb.append(g[j][i])
                sb.append(":")
            }
            val key = sb.toString()
            res += (rows[key] ?: 0)
        }

        return res
    }
}
