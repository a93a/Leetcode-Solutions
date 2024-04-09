class Solution {
    fun timeRequiredToBuy(t: IntArray, k: Int): Int {
        var res = 0
        for (i in t.indices) {
            var cost = minOf(t[i], t[k])
            if (i > k && t[i] >= t[k]) cost--
            res += minOf(t[k], cost)
        }
        return res
    }
}
