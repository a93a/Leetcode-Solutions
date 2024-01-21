class Solution {
    fun countOfPairs(n: Int, x: Int, y: Int): IntArray {
        val res = IntArray (n)

        for (i in 1..n) {
            for (j in (i + 1)..n) {
                var dist = minOf(
                    Math.abs(i - j),
                    Math.abs(i - y) + Math.abs(x - j) + 1,
                    Math.abs(i - x) + Math.abs(y - j) + 1,
                )
                res[dist - 1] += 2
            }
        }

        return res
    }
}
