class Solution {
    fun findMedianSortedArrays(_a: IntArray, _b: IntArray): Double {
        var a = _a
        var b = _b

        if (a.size > b.size) {
            a = b.also { b = a }
        }

        val total = a.size + b.size
        var left = 0
        var right = a.size
        while (left <= right) {
            var part1 = (left + right) / 2
            var part2 = (total + 1 ) / 2 - part1

            var left1 = if (part1 == 0) Int.MIN_VALUE else a[part1 - 1]
            var right1 = if (part1 == a.size) Int.MAX_VALUE else a[part1]
            var left2 = if (part2 == 0) Int.MIN_VALUE else b[part2 - 1]
            var right2 = if (part2 == b.size) Int.MAX_VALUE else b[part2]

            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 == 0)
                    return (maxOf(left1, left2) + minOf(right1, right2)) / 2.0
                else
                    return maxOf(left1, left2).toDouble()
            } else if (left1 > right2) {
                right = part1 - 1
            } else {
                left = part1 + 1
            }
        }

        return -1.0
    }
}
