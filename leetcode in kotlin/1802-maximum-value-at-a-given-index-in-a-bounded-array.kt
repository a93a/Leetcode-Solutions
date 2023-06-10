class Solution {
    fun maxValue(n: Int, index: Int, _maxSum: Int): Int {
        var maxSum = _maxSum - n
        var left = 0
        var right = maxSum

        fun check(mid: Int): Boolean {
            val leftOf = maxOf(mid - index, 0)
            val rightOf = maxOf(mid - ((n - 1) - index), 0)
            var res = 0L
            /*
             * math formula to get sum of sequence x, x + 1, x + 2, .... y ->
             * (x + y) * (x - y + 1) / 2
             * convert beginning of formula to long to avoid Integer overflow
             */
            res += (mid + leftOf).toLong() * (mid - leftOf + 1) / 2
            res += (mid + rightOf).toLong() * (mid - rightOf + 1) / 2
            return (res - mid) <= maxSum
        }

        while (left < right) {
            val mid = (left + right + 1) / 2
            if (check(mid)) left = mid
            else right = mid - 1
        }

        return left + 1
    }
}
