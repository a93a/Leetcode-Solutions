class Solution {
    fun calculate(s: String): Int {
        val stack = LinkedList<Int>()
        var res = 0
        var cur = 0
        var sign = 1

        for (c in s) {
            if (c.isDigit()) {
                cur = 10 * cur + Character.getNumericValue(c)
            } else if (c == '+') {
                res += sign * cur
                cur = 0
                sign = 1
            } else if (c == '-') {
                res += sign * cur
                cur = 0
                sign = -1
            } else if (c == '(') {
                stack.addLast(res)
                stack.add(sign)
                sign = 1
                res = 0
            } else if (c == ')') {
                res += sign * cur
                cur = 0
                res *= stack.removeLast()
                res += stack.removeLast()
            } else {
                //ignore whitespace
            }
        }
       
        return if (cur != 0) res + sign * cur else res
    }
}
