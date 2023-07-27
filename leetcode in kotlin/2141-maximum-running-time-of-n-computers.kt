class Solution {
    fun maxRunTime(n: Int, batteries: IntArray): Long {
        val btrs = batteries.map{it.toLong()}.toLongArray()
        btrs.sort()
        
        fun can(t: Long): Boolean {
            var sum = 0L
            for (b in btrs) sum += minOf(t, b)
            return sum >= n * t
        }

        var l = 1L
        var r = btrs.sum()!!
        while (l < r) {
            val m = (l + r + 1) / 2
            if (can(m))
                l = m
            else
                r = m - 1
        }

        return l
    }
}
