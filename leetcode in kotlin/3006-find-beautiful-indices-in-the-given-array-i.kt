// Brute force
class Solution {
    fun beautifulIndices(s: String, a: String, b: String, k: Int): List<Int> {
        val n = s.length
        val m = a.length
        val p = b.length
        val AS = mutableListOf<Int>()
        val BS = mutableListOf<Int>()

        for (i in 0 until n) {
            if (i + m <= n && s.substring(i, i + m) == a)
                AS.add(i)
            if (i + p <= n && s.substring(i, i + p) == b)
                BS.add(i)
        }

        val res = mutableListOf<Int>()
        val added = hashSetOf<Int>()
        for (i in AS) {
            for (j in BS) {
                if (Math.abs(j - i) <= k && i !in added) {
                    res.add(i)
                    added.add(i)
                }
            }
        }

        return res
    }
}
