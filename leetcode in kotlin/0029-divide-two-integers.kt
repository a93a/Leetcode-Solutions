class Solution {
    fun divide(_num: Int, _div: Int): Int {
        if (_num == Integer.MIN_VALUE && _div == -1) return Integer.MAX_VALUE

        var num = Math.abs(_num)
        var div = Math.abs(_div)

        var res = 0
        for (x in 31 downTo 0) {
            if ((num ushr x) - div >= 0) {
                res += (1 shl x)
                num -= (div shl x)
            }
        }

        val bothSameNegation = (_num > 0) == (_div > 0)
        return if (bothSameNegation) res else -res
    }
}
