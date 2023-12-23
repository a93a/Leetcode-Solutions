class Solution {
    fun countTestedDevices(bp: IntArray): Int {
        var tested = 0

        for (i in bp.indices) {
            if (bp[i] > 0)
                bp[i] = maxOf(bp[i] - tested, 0)
            if (bp[i] > 0)
                tested++
        }
        
        return tested
    }
}
