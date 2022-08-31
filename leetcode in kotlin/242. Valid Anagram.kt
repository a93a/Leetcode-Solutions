class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length)
            return false         
        val map = HashMap<Char,Int>()
        for(c in s.toCharArray())
            map[c] = map.getOrDefault(c,0) + 1
        for(c in t.toCharArray()){
            if(!map.containsKey(c))
                return false   
            else
                map[c] = map[c]!!-1
            if(map[c] == 0)
                map.remove(c)
        }
        return map.isEmpty();
    }
}
