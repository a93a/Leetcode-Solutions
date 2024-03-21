class Solution {
    fun sumOfEncryptedInt(nums: IntArray): Int {
        var res = 0
        nums.forEach {
            res += it.enc()
        }
        return res
    }

    fun Int.enc(): Int {
        var x = this
        var max = -1
        var count = 0
        while (x > 0) {
            max = maxOf(max, x % 10)
            count++
            x /= 10
        }
        var res = 0
        repeat (count) {
            res *= 10
            res += max
        }
        return res
    }
}
