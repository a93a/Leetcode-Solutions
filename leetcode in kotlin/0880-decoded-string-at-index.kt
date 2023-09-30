class Solution {
    fun decodeAtIndex(s: String, _k: Int): String {
        var len = 0L
        var k = _k.toLong()

        for (c in s) {
            if (c in '0'..'9') 
                len *= (c - '0')
            else 
                len++
        }

        var res = ""
        for (c in s.reversed()) {
            if (c in '0'..'9') {
                len /= (c - '0')
                k %= len
            } else {
                k %= len
                if (k == 0L) {
                    res += c
                    break
                }
                len--
            }
        }

        return res
    }
}
