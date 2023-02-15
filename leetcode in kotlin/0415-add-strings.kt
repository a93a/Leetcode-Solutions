class Solution {
    fun addStrings(num1: String, num2: String): String {
        
        var n1 = num1.lastIndex
        var n2 = num2.lastIndex
        var carry = 0
        val sb = StringBuilder()

        while (n1 >= 0 || n2 >= 0 || carry > 0) {
            val digit1 = if(n1 >= 0) num1[n1] - '0' else 0
            val digit2 = if(n2 >= 0) num2[n2] - '0' else 0
            val sum = digit1 + digit2 + carry
            sb.insert(0, sum % 10)
            carry = sum / 10
            n1--
            n2--
        }

        return sb.toString()
    }
}
