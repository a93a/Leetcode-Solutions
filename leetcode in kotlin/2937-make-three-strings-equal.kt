class Solution {
    fun findMinimumOperations(s1: String, s2: String, s3: String): Int {
        if (s1[0] != s2[0] || s1[0] != s3[0]) return -1
    
        val n = minOf(s1.length, s2.length, s3.length)
        val sum = s1.length + s2.length + s3.length
        var i = 0
        while (i < n && s1[i] == s2[i] && s1[i] == s3[i])
            i++

        return sum - 3 * i
    }
}
