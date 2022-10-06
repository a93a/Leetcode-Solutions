class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val hm = HashMap<Char, Int>()
        for(c in magazine)
            hm[c] = hm.getOrDefault(c,0) + 1
        for(c in ransomNote){
            if(hm.getOrDefault(c,0) == 0)
                return false
            hm[c] = hm.getOrDefault(c,0) - 1
        }    
        return true
    }
}
