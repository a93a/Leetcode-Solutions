class Solution {
    fun evalRPN(tokens: Array<String>) = with (LinkedList<Int>()) {
        val ops = listOf("+", "-", "*", "/")

        for (token in tokens) {
            if (token in ops) {
                val b = removeLast()
                val a = removeLast()

                when (token) {
                    "+" -> addLast(a + b)
                    "-" -> addLast(a - b)
                    "*" -> addLast(a * b)
                    "/" -> addLast(a / b)
                }
            } else {
                addLast(token.toInt())
            }
        }

        removeLast()
    }
}
