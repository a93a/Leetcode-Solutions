class TrieNode() {
    val child = arrayOfNulls<TrieNode>(26)
    var isEnd = false
}

class Trie() {

    var root: TrieNode? = null
    
    init{
        root = TrieNode()
    }
    
    fun insert(word: String) {
        var current = root
        for(c in word){
            if(current?.child?.get(c - 'a') == null)
                current?.child?.set(c - 'a', TrieNode())
            current = current?.child?.get(c - 'a')
        }
        current?.isEnd = true
    }

    fun search(word: String): Boolean {
        var current = root
        for(c in word){
            if(current?.child?.get(c - 'a') == null)
                return false
            current = current?.child?.get(c - 'a')
        }
        return current != null && current?.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var current = root
        for(c in prefix){
            if(current?.child?.get(c - 'a') == null)
                return false
            current = current?.child?.get(c - 'a')
        }
        return true
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
