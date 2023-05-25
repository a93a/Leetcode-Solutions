class Solution {
    fun reverseWords(s: String): String {
        val stack = LinkedList<String>()

        var i = 0
        while (i < s.length) {
            if (s[i].isWhitespace()) {
                i++
                continue
            }

            var j = i
            while (j < s.length && !s[j].isWhitespace())
                j++
            stack.addLast(s.substring(i, j))

            i = j + 1
        }

        val res = StringBuilder()
        while (stack.isNotEmpty()) {
            if (res.length > 0)
                res.append(" ")
            res.append(stack.removeLast()) 
        }

        return res.toString()
    }
}
