class Solution {
    fun hammingDistance(x: Int, y: Int): Int {
        var x2 = x
        var y2 = y
        var res = 0
        while (x2 > 0 || y2 > 0) {
            res += if (x2 and 1 != y2 and 1) 1 else 0
            x2 = x2 shr 1
            y2 = y2 shr 1
        }
        return res
    }
}
