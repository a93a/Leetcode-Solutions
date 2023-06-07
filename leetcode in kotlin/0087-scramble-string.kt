class Solution {
    fun isScramble(s1: String, s2: String): Boolean {
        val cache = HashMap<String, Boolean>()    

        fun scramble(s1: String, s2: String): Boolean {
            if (s1 == s2) return true
            if (s1.length == 1) return false
            if (!isAnagram(s1, s2)) return false
            cache["$s1:$s2"]?.let { return it }

            val n = s1.length
            for (i in 1 until n) {
                //swap
                if (scramble(s1.substring(0, i), s2.substring(n - i)) && scramble(s1.substring(i), s2.substring(0, n - i))) {
                    cache["$s1:$s2"] = true
                    return true
                }
                
                //dont swap
                if (scramble(s1.substring(0,i), s2.substring(0,i)) && scramble(s1.substring(i), s2.substring(i))) {
                    cache["$s1:$s2"] = true
                    return true
                }
            }

            cache["$s1:$s2"] = false
            return false
        }

        return scramble(s1, s2)
    }

    fun isAnagram(s1: String, s2: String) = Arrays.equals(s1.chars().sorted().toArray(),
            s2.chars().sorted().toArray())
}
