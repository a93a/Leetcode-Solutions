// compact solution, same time complexity as below, but much faster and less memory according to my leetcode submissions
class Solution {
    
    val dir = arrayOf(
        intArrayOf(1,0),
        intArrayOf(-1,0),
        intArrayOf(0,1),
        intArrayOf(0,-1)
    )
    
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        
        val res = ArrayList<String>()
        val root: TrieNode? = TrieNode()
        
        fun isValid(i: Int, j: Int) = i in (0 until board.size) && j in (0 until board[0].size) && board[i][j] != '.'
        
        fun dfs(i: Int, j: Int, word: String, root: TrieNode?) {
            
            val c = board[i][j]
            val nWord = word + c
            val child = root?.child?.get(c - 'a')
            
            if(child == null) //prefix doesnt exist
                return
            
            if(child.isEnd == true){ //word found 
                res.add(nWord)
                child.isEnd = false //"delete" the word from trie
            }
            
            val temp = board[i][j]
            board[i][j] = '.'
             
            for(d in dir){
                val newI = i + d[0]
                val newJ = j + d[1]
                if(isValid(newI, newJ)){
                    dfs(newI, newJ, nWord, child)
                }
            }
            
            board[i][j] = temp
        }
        
        for(word in words){
            var current = root
            for(c in word){
                if(current?.child?.get(c - 'a') == null)
                    current?.child?.set(c - 'a', TrieNode())
                current = current?.child?.get(c - 'a')
            }
            current?.isEnd = true
        }
        
        for(i in 0 until board.size) {
            for(j in 0 until board[0].size) {
                val c = board[i][j]
                if(root?.child?.get(c - 'a') != null)
                    dfs(i,j, "", root)
            }
        }
        
        return res
    }
}

class TrieNode() {
    val child = arrayOfNulls<TrieNode>(26)
    var isEnd = false
}




//non compact destructed solution with separate Trie logic (same time and space complexity)
class Solution {
    
    val dir = arrayOf(
        intArrayOf(1,0),
        intArrayOf(-1,0),
        intArrayOf(0,1),
        intArrayOf(0,-1)
    )
    
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        
        val res = ArrayList<String>()
        val trie = Trie()
        
        fun isValid(i: Int, j: Int) = i in (0 until board.size) && j in (0 until board[0].size) && board[i][j] != '.'
        
        fun dfs(i: Int, j: Int, word: String) {
            val nWord = word + board[i][j]
                        
            if(trie.prefix(nWord) == false)
                return
            
            val size = res.size
            if(trie.search(nWord) == true){
                res.add(nWord)
                trie.delete(nWord)
            }
            
            val temp = board[i][j]
            board[i][j] = '.'
             
            for(d in dir){
                val newI = i + d[0]
                val newJ = j + d[1]
                if(isValid(newI, newJ)){
                    dfs(newI, newJ, nWord)
                }
            }
            
            board[i][j] = temp
        }
        
        for(word in words)
            trie.insert(word)
        
        for(i in 0 until board.size) {
            for(j in 0 until board[0].size) {
                val c = board[i][j]
                if(trie.prefix(c.toString()))
                    dfs(i,j,"")
            }
        }
        
        return res
    }
}

class Trie() {

    var root: TrieNode? = TrieNode()
    
    fun insert(word: String) {
        var current = root
        for(c in word){
            if(current?.child?.get(c - 'a') == null)
                current?.child?.set(c - 'a', TrieNode())
            current = current?.child?.get(c - 'a')
        }
        current?.isEnd = true
    }
    
    //for simplicity, I will assume that all words exist in the Trie
    // only for this problem, since this will be true always bc of my solution
    // and for simplicity i will detele by setting isEnd == false on the last node of word
    fun delete(word: String) {
        var current = root
        val hm = HashMap<TrieNode?, TrieNode?>() // Child to Parent
        for(c in word){
            val child = current?.child?.get(c - 'a')
            hm.put(child, current)
            current = child
        }
        current?.isEnd = false
        
        
    }
    
    fun hasOneChild(node: TrieNode?): Boolean {
        var res = 0
        for(i in 0 until 26) {
            if(node?.child?.get(i) != null)
                res++
        }
        return res == 1
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

    fun prefix(prefix: String): Boolean {
        var current = root
        for(c in prefix){
            if(current?.child?.get(c - 'a') == null)
                return false
            current = current?.child?.get(c - 'a')
        }
        return true
    }

}

class TrieNode() {
    val child = arrayOfNulls<TrieNode>(26)
    var isEnd = false
}
