class Solution {
    fun minimumLength(s: String): Int {
        var l = 0
        var r = s.lastIndex

        while (l < r && s[l] == s[r]) {
            val cur = s[l]
            while (l <= r && s[l] == cur)
                l++
            while (l <= r && s[r] == cur)
                r--
        }
        
        return if (l > r) 0 else r - l + 1
    }
}
