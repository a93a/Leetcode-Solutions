// DIY logic, Time complexity O(n) and space O(1)
class Solution {
    fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
        var maxD = -1.0
        var maxA = -1

        for ((l, w) in dimensions) {
            val dia = Math.sqrt(l.toDouble() * l + w.toDouble() * w)
            val area = l * w

            if (dia > maxD || maxD == dia && area > maxA) {
                maxD = dia
                maxA = area
            }
        }

        return maxA
    }
}

// or use power of kotlin! Time complexity O(nlogn) and space O(n)
class Solution {
    fun areaOfMaxDiagonal(dimensions: Array<IntArray>) = dimensions
        .map { Math.sqrt(it[0].toDouble() * it[0] + it[1] * it[1]) to it[0] * it[1] }
        .sortedWith(compareBy({ -it.first }, { -it.second }))
        .get(0)
        .second
}
