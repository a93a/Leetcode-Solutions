// count, add by order, add rest
class Solution {
    fun customSortString(order: String, s: String): String {
        val freq = IntArray (26)
        for (c in s)
            freq[c - 'a']++
        
        val res = StringBuilder ()
        for (c in order) {
            while (freq[c - 'a'] > 0) {
                res.append(c)
                freq[c - 'a']--
            }
        }

        for (c in 0 until 26) {
            while (freq[c] > 0) {
                res.append('a' + c)
                freq[c]--
            }
        }

        return res.toString()
    }
}

// get order, sort by order, count and append to res
class Solution {
    fun customSortString(order: String, s: String): String {
        val letters = IntArray (26) { 25 }
        for ((i, c) in order.withIndex())
            letters[c - 'a'] = i

        val g = letters.withIndex()
            .sortedBy { it.value }
            .map { ('a' + it.index) }
        
        val freq = IntArray (26)
        for (c in s)
            freq[c - 'a']++

        val res = StringBuilder ()
        for (c in g) {
            while (freq[c - 'a'] > 0) {
                res.append(c)
                freq[c - 'a']--
            }
        }
    
        return res.toString()
    }
}
