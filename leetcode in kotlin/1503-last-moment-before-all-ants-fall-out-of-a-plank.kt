class Solution {
    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
        var res = 0
        for (m in right)
            res = maxOf(res, n - m)
        for (m in left)
            res = maxOf(res, m)
        return res
    }
}
