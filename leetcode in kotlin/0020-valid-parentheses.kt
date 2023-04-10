class Solution {
    fun isValid(s: String): Boolean {
        val leftSymbols = LinkedList<Char>()
        
        for (c in s) {
            if (c == '(' || c == '{' || c == '[') {
                leftSymbols.addLast(c)
            } else if (c == ')' && !leftSymbols.isEmpty() && leftSymbols.peekLast() == '(') {
                leftSymbols.removeLast()
            } else if (c == '}' && !leftSymbols.isEmpty() && leftSymbols.peekLast() == '{') {
                leftSymbols.removeLast()
            } else if (c == ']' && !leftSymbols.isEmpty() && leftSymbols.peekLast() == '[') {
                leftSymbols.removeLast()
            } else {
                return false
            }
        }

        return leftSymbols.isEmpty()
    }
}
