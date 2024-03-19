class Solution {
    fun minimumDeletions(word: String, k: Int): Int {
        val freq = IntArray (26)
        for (c in word)
            freq[c - 'a']++

        freq.sort()
        val max = freq.max() ?: 0
        var res = Integer.MAX_VALUE
        for (f in 1..max) {
            var cur = 0
            for (f2 in freq) {
                if (f2 > f + k)
                    cur += f2 - f - k
                else if (f2 < f)
                    cur += f2
            }
            res = minOf(res, cur)
        }
        
        return res
    }
}
