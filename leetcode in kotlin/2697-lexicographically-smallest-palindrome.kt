class Solution {
    fun makeSmallestPalindrome(s: String): String {
        var l = 0
        var r = s.lastIndex

        val res = s.toCharArray()
        while (l <= r) {
            if (s[l] < s[r])
                res[r] = s[l]
            else
                res[l] = s[r]
            l++
            r--
        }

        return String(res)
    }
}
