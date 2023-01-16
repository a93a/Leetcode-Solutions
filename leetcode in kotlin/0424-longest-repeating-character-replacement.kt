class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val hm = IntArray(26)
        var res = 0; var l = 0; var max = 0
        for(r in 0..s.length-1){
            hm[s[r] - 'A']++
            max = maxOf(max,hm[s[r] - 'A'])
            if(r - l + 1 - max > k){
                hm[s[l] - 'A']--
                l++
            }
            res = maxOf(res, r - l + 1)
        }
        return res
    }
}
