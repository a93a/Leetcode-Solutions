class Solution {
    fun canMakeSubsequence(a: String, b: String): Boolean {
        var i = 0
        var j = 0
        while (i < a.length && j < b.length) {
            if (a[i] == b[j] || a[i] + 1 == b[j] || a[i] - 25 == b[j])
                j++
            i++
        }
        
        return j == b.length
    }
}
