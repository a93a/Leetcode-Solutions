class Solution {
    fun shortestToChar(s: String, c: Char): IntArray {
        var res = IntArray(s.length)

        var lastSeen = -1 * s.length
        for (i in 0 until s.length) {
            if (s[i] == c) lastSeen = i
            res[i] = i - lastSeen
        }

        for (i in lastSeen downTo 0) {
            if (s[i] == c) lastSeen = i
            res[i] = minOf(res[i], lastSeen - i)
        }

        return res
    }
}
