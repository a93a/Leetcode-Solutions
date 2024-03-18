class Solution {
    fun countSubstrings(s: String, c: Char): Long {
        val n = s.length
        val count = IntArray (n)

        for (i in (n - 1) downTo 0) {
            if (s[i] == c) count[i] = 1
            if (i < n - 1) count[i] += count[i + 1]
        }

        var res = 0L
        for (i in s.indices) {
            if (s[i] == c) res += count[i]
        }

        return res
    }
}
