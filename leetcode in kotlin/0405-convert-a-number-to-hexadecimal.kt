class Solution {
    fun toHex(num: Int) = buildString {
        if (num == 0) return "0"

        var n = num
        while (n != 0) {
            val bits = n and 0xF
            val hex = if (bits < 10) ('0' + bits) else ('a' + (bits - 10))
            insert(0, hex)
            n = n ushr 4
        }
    }
}
