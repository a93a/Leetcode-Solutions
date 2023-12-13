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

    fun fastPow(a: Int, b: Int, m: Int): Int {
        if (b == 0) return 1
        if (b == 1) return a % m
        val x = fastPow(a, b / 2, m)
        if (b % 2 == 0)
            return x * x % m
        return (x * x * a) % m
    }
}
