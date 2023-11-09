class Solution {
    fun countHomogenous(s: String): Int {
        val mod = 1_000_000_000 + 7

        var res = 0
        var i = 0
        while (i < s.length) {
            var j = i + 1
            var sameCount = 1
            while (j < s.length && s[i] == s[j]) {
                sameCount++
                j++
            }

            val n = sameCount.toLong()
            val subStrSum = (n * (n + 1) / 2) % mod
            res += subStrSum.toInt()
            i = j
        }

        return res
    }
}
