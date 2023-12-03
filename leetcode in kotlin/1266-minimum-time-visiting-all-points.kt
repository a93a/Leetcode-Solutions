class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var res = 0
        for (i in 1..points.lastIndex) {
            res += maxOf(
                abs(points[i][0] - points[i - 1][0]),
                abs(points[i][1] - points[i - 1][1])
            )
        }
        return res
    }
}

// bunch of different kotlin style solutions....
class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>) = points
        .foldIndexed (0) { i, sum, point ->
            if (i > 0) {
                sum + maxOf(
                    abs(points[i][0] - points[i - 1][0]),
                    abs(points[i][1] - points[i - 1][1])
                )
            } else {
                sum
            }
        }
}

class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>) = points
        .asSequence()
        .zipWithNext()
        .sumOf { (a, b) ->
            maxOf(
                abs(a[0] - b[0]), 
                abs(a[1] - b[1])
            )
        }
}

class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>) = points
        .asSequence()
        .windowed(2)
        .sumOf { (a, b) ->
            maxOf(
                abs(a[0] - b[0]), 
                abs(a[1] - b[1])
            )
        }
}

class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>) = (1..points.lastIndex)
        .sumOf { i ->
            maxOf(
                abs(points[i][0] - points[i - 1][0]), 
                abs(points[i][1] - points[i - 1][1])
            )
        }
}
