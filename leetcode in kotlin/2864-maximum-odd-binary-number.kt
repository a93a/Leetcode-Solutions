class Solution {
    fun maximumOddBinaryNumber(s: String): String {
        var count = s.count  { it == '1' } - 1
        val n = s.length

        val res = StringBuilder()
        for (i in 0 until n - 1) {
            if (count > 0) {
                res.append("1")
                count--
            } else {
                res.append("0")
            }
        }

        res.append("1")
        return res.toString()
    }
}
