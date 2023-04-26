/*
* Math one liner
*/
class Solution {
    fun addDigits(num: Int) = (num - 1) % 9 + 1
}

/*
* Iteration
*/
class Solution {
    fun addDigits(num: Int): Int {
        var s = 0
        var n = num

        while (n > 9){
            while (n > 0) {
                s += (n % 10)
                n /= 10
            }
            n = s
            s = 0
        }

        return n
    }
}
