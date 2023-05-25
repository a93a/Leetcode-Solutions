class Solution {
    fun maxPoints(points: Array<IntArray>): Long {
        val m = points.size
        val n = points[0].size
        val prev = points[0].map { it.toLong() }.toLongArray()
        val left = LongArray(n)
        val right = LongArray(n)

        for (i in 1 until m) {
            for (j in 0 until n) {
                if (j > 0)
                    left[j] = maxOf(left[j - 1] - 1, prev[j])
                else
                    left[0] = prev[0]
            }

            for (j in n - 1 downTo 0) {
                if (j < n - 1)
                    right[j] = maxOf(right[j + 1] - 1, prev[j])
                else
                    right[n - 1] = prev[n - 1]
            }

            for (j in 0 until n) {
                prev[j] = points[i][j] + maxOf(left[j], right[j])
            }
        }

        return prev.max()?: 0L
    }
}
