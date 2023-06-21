class Solution {
    fun minCost(n: IntArray, c: IntArray): Long {
        var left = 1L
        var right = 1000000L
        var res = 0L

        while (left < right) {
            val mid = (left + right) / 2
            var resL = 0L
            var resR = 0L

            for (i in n.indices) {
                resL += c[i] * Math.abs(n[i] - mid)
                resR += c[i] * Math.abs(n[i]  - (mid + 1))
            }

            res = minOf(resL, resR)

            if (resL < resR)
                right = mid
            else
                left = mid + 1
        }

        return res
    }
}
