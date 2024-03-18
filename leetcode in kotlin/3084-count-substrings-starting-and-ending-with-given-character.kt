// Count, iterate and update count
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

// Get count and use summation formula of 1..n.
class Solution {
    fun countSubstrings(s: String, c: Char): Long {
        val n = s.length
        var count = 0

        for (i in s.indices) {
            if (s[i] == c)
                count++
        }

        return count.toLong() * (count + 1) / 2
    }
}
