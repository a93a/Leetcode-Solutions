class Solution {
    var root = TrieNode()

    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val res = HashSet<Pair<Int, Int>>()

        val selfPalIndices = mutableListOf<Int>().apply {
            words.forEachIndexed { i, word -> 
                if (isPal(word, 0, word.lastIndex))
                    add(i)
            }
        }

        words.forEachIndexed { i, word ->
            val m = word.length
            if (word == "") {
                selfPalIndices.forEach { j ->
                    if (i != j) {
                        res.add(i to j)
                        res.add(j to i)
                    }
                }
            } else {
                insert(word.reversed(), i)
            }
        }

        words.forEachIndexed { i, word -> 
            val wordIndices = search(word, i)
            wordIndices.forEach { j ->
                if (i != j)
                    res.add(i to j)
            }
        }

        return res.map { listOf(it.first, it.second) }
    }

    private fun insert(word: String, index: Int) {
        var cur: TrieNode? = root

        for (i in word.indices) {
            val c = word[i]

            if (cur?.children?.get(c - 'a') == null)
                cur?.children?.set(c - 'a', TrieNode())
            cur = cur?.children?.get(c - 'a')

            if (cur != null && isPal(word, i + 1, word.lastIndex))
                cur.palindromIndices.add(index)
        }

        cur?.isEnd = index
    }

    private fun search(word: String, index: Int): MutableList<Int> {
        var cur: TrieNode? = root
        var resIndices = mutableListOf<Int>()

        for (i in word.indices) {
            val c = word[i]
            if (cur != null && cur.isEnd > -1 && isPal(word, i, word.lastIndex))
                resIndices.add(cur.isEnd)
                
            if (cur?.children?.get(c - 'a') == null)
                return resIndices
            cur = cur?.children?.get(c - 'a')
        }

        if (cur != null && cur.isEnd > -1 && cur.isEnd != index)
            resIndices.add(cur.isEnd)
        if (cur != null && cur.palindromIndices.isNotEmpty())
            resIndices.addAll(cur.palindromIndices)

        return resIndices
    }

    private fun isPal(word: String, _i: Int, _j: Int): Boolean {
        var i = _i
        var j = _j

        while (i < j) {
            if (word[i++] != word[j--])
                return false
        }

        return true
    }
}

class TrieNode() {
    var children = arrayOfNulls<TrieNode?>(26)
    var isEnd = -1
    var palindromIndices = mutableListOf<Int>()
}
