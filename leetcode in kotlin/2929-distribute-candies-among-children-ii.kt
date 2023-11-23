class Solution {
    fun distributeCandies(n: Int, limit: Int): Long {
        var res = 0L
        for (firstTake in 0..minOf(n, limit)) {
            val secondMax = minOf(limit, n - firstTake)
            val secondMin = maxOf(0, n - firstTake - limit)
            res += maxOf(secondMax - secondMin + 1, 0)
        }
        return res
    }
}
