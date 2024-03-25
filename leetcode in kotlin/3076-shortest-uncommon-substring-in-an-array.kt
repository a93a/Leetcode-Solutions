class Solution {
    fun shortestSubstrings(words: Array<String>): Array<String> {
        val trie = Trie ()
        words.forEachIndexed { index, word -> trie.insert(word, index) }

        val res = Array<String> (words.size) { "" }
        words.forEachIndexed { index, word -> res[index] = trie.find(word) }
        return res
    }
}

class Trie {
    val root = TrieNode()

    fun insert(word: String, index: Int) {
        for (i in word.indices) {
            var cur: TrieNode? = root
            for (j in i until word.length) {
                val c = word[j]
                if (cur?.children?.get(c - 'a') == null)
                    cur?.children?.set(c - 'a', TrieNode())
                cur = cur?.children?.get(c - 'a')
                cur?.isEnd?.add(index)
            }
        }
    }

    fun find(word: String): String {
        val res = mutableListOf<String>()

        for (i in word.indices) {
            var cur: TrieNode? = root
            val sb = StringBuilder ()
            for (j in i until word.length) {
                val c = word[j]
                sb.append(c)
                cur = cur?.children?.get(c - 'a') ?: break
                if (cur.isEnd.size == 1) {
                    res.add(sb.toString())
                    break
                }
            }
        }

        res.sortWith(compareBy({ it.length }, { it }))
        return res.firstOrNull() ?: ""
    }
}

class TrieNode() {
    var children = arrayOfNulls<TrieNode?>(26)
    var isEnd = mutableSetOf<Int>()
}
