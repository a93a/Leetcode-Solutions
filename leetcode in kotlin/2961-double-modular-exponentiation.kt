class Solution {
    fun getGoodIndices(variables: Array<IntArray>, target: Int): List<Int> {
        var res = mutableListOf<Int>()
        for ((i, v) in variables.withIndex()) {
            val (a, b, c, m) = v
            if (fastPow(fastPow(a, b, 10), c, m) == target)
                res.add(i)
        }
        return res
    }

    // fast mod
    fun fastPow(base: Int, exp: Int, mod: Int): Int {
        if (mod == 1) return 0
        var res = 1
        for (e in 0 until exp) {
            res = (res * base) % mod
        }
        return res
    }
}

class Solution {
    fun getGoodIndices(variables: Array<IntArray>, target: Int): List<Int> {
        var res = mutableListOf<Int>()
        for ((i, v) in variables.withIndex()) {
            val (a, b, c, m) = v
            if (fastPow(fastPow(a, b, 10), c, m) == target)
                res.add(i)
        }
        return res
    }

    // fast mod binary method
    fun fastPow(base: Int, exp: Int, mod: Int): Int {
        if (mod == 1) return 0
        var res = 1
        var b = base % mod
        var e = exp
        while (e > 0) {
            if (e % 2 == 1)
                res = (res * b) % mod
            e = e shr 1
            b = (b * b) % mod
        }
        return res
    }
}
