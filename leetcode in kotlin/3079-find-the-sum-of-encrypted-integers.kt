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
        var res = 0
        while (x > 0) {
            max = maxOf(max, x % 10)
            res = res * 10 + 1
            x /= 10
        }
        return res * max
    }
}
