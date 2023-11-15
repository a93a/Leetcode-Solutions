class Solution {
    fun hasAlternatingBits(n: Int): Boolean {
        var x = n
        var prev = x and 1
        x = x shr 1
        while (x > 0) {
            var cur = x and 1
            if (cur == prev) return false
            prev = cur
            x = x shr 1
        }
        return true
    }
}
