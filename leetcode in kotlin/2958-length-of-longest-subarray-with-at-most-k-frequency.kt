class Solution {
    fun maxSubarrayLength(n: IntArray, k: Int): Int {
        val freq = HashMap<Int, Int>()
        var res = 0
        var l = 0

        for (r in n.indices) {
            freq[n[r]] = (freq[n[r]] ?: 0) + 1
            while (l < n.size && (freq[n[r]] ?: 0) > k) {
                freq[n[l]] = (freq[n[l]] ?: 0) - 1
                l++
            }

            res = maxOf(res, r - l + 1)
        }

        return res
    }
}
