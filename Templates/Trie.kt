class Trie() {
    var root = TrieNode()

    fun insert(word: String) {
        var cur: TrieNode? = root
        for (c in word) {
            if (cur?.children?.get(c - 'a') == null)
                cur?.children?.set(c - 'a', TrieNode())
            cur = cur?.children?.get(c - 'a')
        }
        cur?.isEnd = true
    }

    fun search(word: String): Boolean {
        var cur: TrieNode? = root
        for (c in word) {
            if (cur?.children?.get(c - 'a') == null)
                return false
            cur = cur?.children?.get(c - 'a')
        }
        return cur?.isEnd ?: false
    }

    fun startsWith(prefix: String): Boolean {
        var cur: TrieNode? = root
        for (c in prefix) {
            if (cur?.children?.get(c - 'a') == null)
                return false
            cur = cur?.children?.get(c - 'a')
        }
        return true
    }
}

class TrieNode() {
    var children = arrayOfNulls<TrieNode?>(26)
    var isEnd = false
}