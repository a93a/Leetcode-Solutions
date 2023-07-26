class Solution {
    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        
        fun can(t: Double): Boolean {
            var res = 0.0
            for (i in 0 until dist.lastIndex) 
                res += Math.ceil(dist[i].toDouble() / t)
            res += (dist[dist.lastIndex].toDouble() / t)
            return res <= hour
        }

        var l = 1
        var r = 10000000
        var res = -1
        while (l <= r) {
            val m = (l + r) / 2
            if (can(m.toDouble())) {
                res = m
                r = m - 1
            } else {
                l = m + 1
            }
        }

        return res
    }
}
