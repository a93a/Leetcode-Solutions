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

// Same logic as above, but add inverse symbols to stack.
// We can do an early break when encoutering our first bad match.
class Solution {
    fun isValid(s: String): Boolean {
        val stack = LinkedList<Char> ()

        for (c in s) {
            if (c == '(')
                stack.addLast(')')
            else if (c == '{')
                stack.addLast('}')
            else if (c == '[')
                stack.addLast(']')
            else if (stack.isEmpty() || stack.removeLast() != c)
                return false
        }

        return stack.isEmpty()
    }
}
