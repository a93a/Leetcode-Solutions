// Use the sum formula to find that sqrt * sqrt == sum
class Solution {
    fun pivotInteger(n: Int): Int {
        var sum = n * (n + 1) / 2
        var sqrt = Math.sqrt(sum.toDouble()).toInt()
        return if (sqrt * sqrt == sum) sqrt else -1
    }
}

// Binary search to find the pivot, using the fact that sqrt * sqrt == sum
class Solution {
    fun pivotInteger(n: Int): Int {
        val sum = n * (n + 1) / 2

        var l = 1
        var r = n
        var x = -1
        while (l < r) {
            val m = (l + r) / 2

            if (m * m < sum) {
                l = m + 1
            } else {
                r = m
            }
        }

        return if (l * l == sum) l else -1
    }
}
