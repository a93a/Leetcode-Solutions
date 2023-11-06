class Solution {
    fun getWinner(a: IntArray, _k: Int): Int {
        val n = a.size
        var k = minOf(_k, n - 1)

        var cur = a[0]
        var streak = 0
        for (i in 1 until n) {
            if (a[i] < cur) {
                streak++
            } else {
                streak = 1
                cur = a[i]
            }
            if (streak == k)
                break
            
        }

        return cur
    }
}
