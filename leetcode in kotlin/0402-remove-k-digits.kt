class Solution {
    fun removeKdigits(s: String, k: Int): String {
        val q = LinkedList<Char> ()

        var k = k
        for (i in s.indices) {
            while (k > 0 && q.isNotEmpty() && s[i] < q.peekLast()) {
                q.removeLast()
                k--
            }
            q.addLast(s[i])
        } 

        repeat (k) {
            q.removeLast()
        }

        while (q.isNotEmpty() && q.peekFirst() == '0') 
        q.removeFirst()

        return if(q.isEmpty()) "0" else q.joinToString("")
    }
}
