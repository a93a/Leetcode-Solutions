class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {

        if(s1.length > s2.length) return false

        val s1Map = IntArray(26)
        val s2Map = IntArray(26)

        for (i in s1.indices) {
            s1Map[s1[i] - 'a']++
            s2Map[s2[i] - 'a']++
        }
            
        for (i in 0..s2.lastIndex - s1.length) {
            if (s1Map contentEquals s2Map) return true
            s2Map[ s2[i] - 'a']--
            s2Map[ s2[i + s1.length] - 'a']++
        }

        return s1Map contentEquals s2Map
    }
}
