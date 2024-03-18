class Solution {
    fun countSubstrings(s: String, c: Char): Long {
        val n = s.length
        var count = 0

        for (i in s.indices) {
            if (s[i] == c)
                count++
        }

        var res = 0L
        for (i in s.indices) {
            if (s[i] == c) {
                res += count
                count--
            }
        }

        return res
    }
}
