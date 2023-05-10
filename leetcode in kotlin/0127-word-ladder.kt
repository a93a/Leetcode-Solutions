class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (endWord !in wordList) return 0
        val wordList2 = wordList + listOf(beginWord)
        
        val adj = HashMap<String, ArrayList<String>>().apply {
            for (word1 in wordList2) {
                secondary@ for (word2 in wordList2) {
                    if (word1 == word2) continue
                    var mismatch = 0
                    for (i in 0 until word1.length) {
                        if (word1[i] != word2[i]) {
                            if (++mismatch == 2) continue@secondary
                        }
                    }
                    this[word1] = getOrDefault(word1, ArrayList<String>()).apply { add(word2) }
                }
            }
        }

        var length = 0
        val visited = HashSet<String>().apply { add(beginWord) }

        val q = LinkedList<String>().apply { 
            addFirst(beginWord) 
            while (isNotEmpty()) {
                length++
                repeat(size) {
                    val word = removeLast()
                    if (word == endWord) return length
                    adj[word]?.forEach {
                        if (it !in visited) {
                            visited.add(it)
                            addFirst(it)
                        }
                    }
                }
            }
        }
        
        return 0
    }
}
