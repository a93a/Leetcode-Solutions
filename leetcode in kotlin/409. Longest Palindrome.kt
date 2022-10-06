class Solution {
    fun longestPalindrome(s: String): Int {
        val hm = HashMap<Char, Int>()
        var res = 0
        for(c in s)
            hm[c] = hm.getOrDefault(c, 0) + 1
        for((c,i) in hm){
            res += i/2 * 2
            if(res%2 == 0 && i%2 == 1) //if (only once) we have an odd char count
                res++
        }
        return res
    }
}
