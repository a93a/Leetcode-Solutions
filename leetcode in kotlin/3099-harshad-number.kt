class Solution {
    fun sumOfTheDigitsOfHarshadNumber(x: Int): Int {
        var y = x
        var sum = 0
        while (y > 0) {
            sum += (y % 10)
            y /= 10
        }
        return if (x % sum == 0) sum else -1
    }
}
