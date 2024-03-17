class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val res = ArrayList<IntArray>()

        var added = false
        var index = 0
        for (i in 0 until intervals.size) {
            val interval = intervals[i]

            if (newInterval[1] < interval[0]) {
                res.add(newInterval)
                added = true
                break
            } else if (newInterval[0] > interval[1]) {
                res.add(interval)
            } else {
                newInterval[0] = minOf(newInterval[0], interval[0])
                newInterval[1] = maxOf(newInterval[1], interval[1])
            }
            
            index++
        }

        if (index < intervals.size) {
            for (i in index until intervals.size)
                res.add(intervals[i])
        }

        if (!added)
            res.add(newInterval)

        return res.toTypedArray()
    }
}
