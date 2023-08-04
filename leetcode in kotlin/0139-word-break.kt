//DP solution
class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val cache = BooleanArray (s.length + 1).apply {
            this[s.length] = true 
        }
        
        for (i in s.lastIndex downTo 0) {
            for (word in wordDict) {
                if (word.length + i <= s.length) {
                    if (word == s.substring(i, i + word.length)) {
                        if (cache[i + word.length] == true) 
                            cache[i] = true
                    }
                }
            }
        }
        return cache[0]
    }
}
