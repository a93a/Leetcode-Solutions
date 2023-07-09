class Solution {
    fun putMarbles(w: IntArray, k: Int): Long {
        val w2 = LongArray (w.size - 1)
        for (i in 0 until w2.size)
            w2[i] = w[i].toLong() + w[i + 1].toLong()
        w2.sort()

        var res = 0L
        for (i in 0 until k - 1)
            res += w2[w.size - 1 - 1 - i] - w2[i]

        return res
    }
}
