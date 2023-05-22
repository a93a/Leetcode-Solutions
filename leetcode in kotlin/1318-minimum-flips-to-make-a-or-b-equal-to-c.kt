class Solution {
    fun minFlips(_a: Int, _b: Int, _c: Int): Int {
        var a = _a
        var b = _b
        var c = _c
        var res = 0

        while (a > 0 || b > 0 || c > 0) {
            if (c and 1 == 0)
                res += ((a and 1) + (b and 1))
            else if (c and 1 == 1 && b and 1 == 0 && a and 1 == 0)
                res += 1

            a = a shr 1
            b = b shr 1
            c = c shr 1
        }  

        return res
    }
}
