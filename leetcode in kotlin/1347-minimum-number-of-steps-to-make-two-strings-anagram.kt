class Solution {
    fun minSteps(s: String, t: String): Int {
        val count = IntArray (26)

        for (c in s)
            count[c - 'a']++
        for (c in t)
            count[c - 'a']--

        var res = 0
        for (v in count) {
            res += if (v < 0) -v else v
        }
            
        return res / 2
    }
}
