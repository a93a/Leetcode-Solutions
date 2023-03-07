class Solution {
    fun minimumTime(time: IntArray, totalTrips: Int): Long {
        var left = 0L
        var right = 100000000000000L

        fun trips(i: Long): Boolean {
            var count = 0L
            for(t in time)
                count += i.toLong() / t
            return count >= totalTrips.toLong()
        }

        while(left < right) {
            val mid = (left + right) / 2
            println(mid)
            if(trips(mid))
                right = mid
            else 
                left = mid + 1
        }

        return left
    }
}
