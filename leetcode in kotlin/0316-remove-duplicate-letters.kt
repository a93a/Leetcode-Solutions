class Solution {
    fun removeDuplicateLetters(s: String): String {
        val stack = LinkedList<Char>()
        var count = IntArray (26)
        var seen = HashSet<Char>()

        for (c in s) count[c - 'a']++

        for (c in s) {
            count[c - 'a']--

            if (c in seen) continue

            while (stack.isNotEmpty() && c < stack.peekLast() && count[stack.peekLast() - 'a'] > 0) {
                val top = stack.removeLast()
                seen.remove(top)
            }
                 
            stack.addLast(c)
            seen.add(c)
        }

        return stack.joinToString("")
    }
}
