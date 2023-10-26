class Solution {
    fun numFactoredBinaryTrees(a: IntArray): Int {
        a.sort()
        val count = HashMap<Int, Long>()
        val mod = 1_000_000_000 + 7

        count[a[0]] = 1L
        for (i in a.indices) {
            var res = 1L
            for (n in count.keys) {
                if (a[i] % n == 0 && count.contains(a[i] / n))
                    res += count[n]!! * count[a[i] / n]!!
            }
            count[a[i]] = res
        }

        var res = 0L
        for (c in count.values)
            res = (res + c) % mod

        return res.toInt()
    }
}
