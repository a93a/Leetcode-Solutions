class TrieNode() {
    val child = arrayOfNulls<TrieNode>(26)
    var isEnd = false
}

class WordDictionary() {
    
    var root: TrieNode? = TrieNode()

    fun addWord(word: String) {
        var current = root
        for(c in word){
            if(current?.child?.get(c - 'a') == null)
                current?.child?.set(c - 'a', TrieNode())
            current = current?.child?.get(c - 'a')
        }
        current?.isEnd = true
    }

    fun search(word: String): Boolean {
        return dfs(word, 0, root)
    }
    
    private fun dfs(word: String, index: Int, tNode: TrieNode?): Boolean {
        var current = tNode
        current?: return false
        if(index > word.length) // e.g ".a" cannot be matched with "a"
            return false
        for(i in index until word.length){
            if(word[i] == '.'){
                current?.child?.forEach {
                    if(dfs(word, i+1, it)) //skip the dot "."
                        return true
                }
                return false
            }else{
                if(current?.child?.get(word[i] - 'a') == null)
                    return false
                current = current?.child?.get(word[i] - 'a')
            }
        }
        return if(current != null) current.isEnd else false //if reached end of "word"
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */
