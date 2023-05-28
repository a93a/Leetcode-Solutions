class Solution {
    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        var root: TrieNode? = TrieNode()
        
        for (s in dictionary) {
            var current = root
            for (c in s){
                if (current?.child?.get(c - 'a') == null)
                    current?.child?.set(c - 'a', TrieNode())
                current = current?.child?.get(c - 'a')
            }
            current?.isEnd = true
        }
        
        val dp = IntArray(s.length + 1)

        for (i in s.lastIndex downTo 0) {
            dp[i] = dp[i + 1] + 1
            var current = root
            for (j in i..s.lastIndex) {
                if (current?.child?.get(s[j] - 'a') == null)
                    break
                current = current?.child?.get(s[j] - 'a')
                if (current?.isEnd == true) {
                    dp[i] = minOf(
                        dp[i],
                        dp[j + 1]
                    )
                }
            }
        }
    
        return dp[0]
    }
    
    class TrieNode() {
        val child = arrayOfNulls<TrieNode>(26)
        var isEnd = false
    }
}
