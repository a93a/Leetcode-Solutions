class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var res = 0
        for (i in 1..points.lastIndex) {
            res += maxOf(
                Math.abs(points[i][0] - points[i - 1][0]),
                Math.abs(points[i][1] - points[i - 1][1])
            )
        }
        return res
    }
}

// With fold()
class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>) = points
        .foldIndexed (0) { i, sum, point ->
            if (i > 0) {
                sum + maxOf(
                    Math.abs(points[i][0] - points[i - 1][0]),
                    Math.abs(points[i][1] - points[i - 1][1])
                )
            } else {
                sum
            }
        }
}
