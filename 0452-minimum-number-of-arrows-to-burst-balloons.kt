class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortWith(compareBy({ it[0] } ,{ it[1] }))
        var count = 1
        var right = points[0][1]

        for (i in 1 until points.size) {
            if (points[i][0] <= right) {
                right = minOf(right, points[i][1])
            } else {
                count++
                right = points[i][1]
            }
        }

        return count
    }
}
