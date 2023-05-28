class Solution {
    fun maxStrength(a: IntArray): Long { 
        val n = a.size
        var res = 1L
        var took = false
        a.sortDescending()

        var i = 0
        while (i < n && a[i] > 0) {
            res *= a[i++]
            took = true
        }

        var j = n - 1
        while (j > 0 && a[j - 1] < 0) {
            res *= a[j--] * a[j--]
            took = true
        }
        
        return if (took) res else a.max()!!.toLong()
    }
}
