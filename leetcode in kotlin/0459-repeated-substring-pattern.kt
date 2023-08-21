class Solution {
    fun repeatedSubstringPattern(s: String): Boolean {
        val n = s.length

        for (i in 1..(n / 2)) {
            if (n % i == 0) {
                if (s.substring(0, i).repeat(n / i) == s)
                    return true
            }
        }

        return false
    }
}
