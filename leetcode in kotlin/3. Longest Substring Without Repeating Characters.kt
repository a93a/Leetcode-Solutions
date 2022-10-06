//sliding window
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val hm = HashMap<Char,Int>()
        var max = 0
        var l = 0
        for((r, c) in s.withIndex()){
            if(hm.contains(c)){
                l = maxOf(hm[c]!! + 1, l)
            }
            hm[c] = r
            max = maxOf(max, r - l + 1)
        }
        return max
    }
}
