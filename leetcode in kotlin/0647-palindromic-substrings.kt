// Two pointer with outwards extension solution, time O(N^2) and space O(1)
class Solution {
    fun countSubstrings(s: String): Int {
        var res = 0

        fun extend(i: Int) {
            var l = i
            var r = i
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                l--; r++; res++
            }
            l = i
            r = i + 1
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                l--; r++; res++
            }
        }

        s.indices.forEach { extend(it) }
        return res
    }
}

// DP solution, time O(N^2) and space O(N^2)
class Solution {
    fun countSubstrings(s: String): Int {
        val n = s.length
        var res = 0
        val dp = Array (n) { BooleanArray(n) }
        for (i in s.lastIndex downTo 0) {
            for (j in i..s.lastIndex) {
                dp[i][j] = s[i] == s[j] && (j - i + 1 < 3 || dp[i + 1][j - 1])
                if (dp[i][j]) res++
            }
        }
        return res
    }
}
