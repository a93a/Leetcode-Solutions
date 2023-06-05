class Solution {
    fun checkStraightLine(c: Array<IntArray>): Boolean {
        val (x0, y0) = c[0]
        val (x1, y1) = c[1]
        for (i in 2 until c.size) {
            val (x, y) = c[i]
            if ((x1 - x0) * (y - y0) != (y1 - y0) * (x - x0))
                return false
        }
        return true
    }
}
