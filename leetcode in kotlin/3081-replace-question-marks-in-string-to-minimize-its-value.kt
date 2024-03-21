class Solution {
    fun minimizeStringValue(s: String): String {
        val freq = IntArray (26)
        for (c in s) {
            if (c != '?') freq[c - 'a']++
        }
        
        val min = PriorityQueue<Pair<Int, Char>> (compareBy( { it.first }, { it.second }))
        for (c in 0..25)
            min.add(freq[c] to ('a' + c))
        
        val rep = mutableListOf<Char> ()
        for (c in s) {
            if (c == '?') {
                val (v, ch) = min.poll()
                rep.add(ch)
                min.add((v + 1) to ch)
            }
        }

        rep.sort()
        val res = StringBuilder ()
        for (c in s) {
            if (c == '?') res.append(rep.removeFirst())
            else res.append(c)
        }

        return res.toString()
    }
}
