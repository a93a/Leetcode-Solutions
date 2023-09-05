class Solution {
    fun minimumOperations(num: String): Int {
        var res = 0
        var anyZero = false
        var anyFive = false

        var i = num.lastIndex
        while (i >= 0) {
            val c = num[i]

            if (anyZero) {
                if (c == '0' || c == '5')
                    return num.length - 2 - i
            }

            if (anyFive) {
                if (c == '2' || c == '7')
                    return num.length - 2 - i
            }
                
            if (num[i] == '0') anyZero = true
            if (num[i] == '5') anyFive = true

            res++
            i--
        }

        return if (anyZero) num.length - 1 else num.length
    }
}
