class Solution {
    fun findPeaks(m: IntArray): List<Int> {
        var res = mutableListOf<Int>()

        for (i in 1 until m.lastIndex) {
            if (m[i - 1] < m[i] && m[i] > m[i + 1])
                res.add(i)
        }

        return res
    }
}
