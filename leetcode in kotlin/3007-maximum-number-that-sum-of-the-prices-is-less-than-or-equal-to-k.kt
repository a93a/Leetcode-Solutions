class Solution {
    fun findMaximumNumber(k: Long, x: Int): Long {

        fun isGood(t: Long): Boolean {
            var total = 0L
            for (i in 1..62) {
                if (i % x == 0) {
                    val e = (1L shl i)
                    total += (t / e) * (e / 2)
                    total += maxOf(0, (t % e) + 1 - (e / 2))
                }
            }
            return total <= k
        }

        var l = 1L
        var r = 1e15.toLong()
        var res = -1L
        while (l <= r) {
            val m = (l + r + 1) / 2
            if (isGood(m)) {
                res = m
                l = m + 1
            } else {
                r = m - 1
            }
        }

        return res
    }
}
