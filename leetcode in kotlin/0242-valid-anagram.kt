class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val count = IntArray (26)
        for (c in s)
            count[c - 'a']++
        for (c in t)
            count[c - 'a']--
        return count.all { it == 0 }
    }
}
