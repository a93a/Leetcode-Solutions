class Solution {
    fun beautifulSubstrings(s: String, k: Int): Int {
        var res = 0

        for (i in 0 until s.length) {
            var v = 0
            var c = 0
            for (j in i until s.length) {
                if (isVow(s[j])) v++
                else c++
                
                if (isBeauty(v, c, k)) res++
            }
        }

        return res
    }

    private fun isBeauty(a: Int, b: Int, k: Int) = a == b && (a * b) % k == 0
    
    private fun isVow(c: Char) = c in setOf('a', 'e', 'i', 'o', 'u')
}
