class Solution {
    val mod = 1000000007

    fun sumOfPower(nums: IntArray): Int {
        var res = 0L
        var pre = 0L

        nums.sort()

        for (n in nums) {
            res = res + pow(n, 3)
            res = (res + (pow(n, 2) * pre)) % mod
            pre = (pre * 2 + n) % mod
        }

        return res.toInt()
    }

    fun pow(x: Int, p: Int): Long {
        var res = 1L
        var p2 = p
        while (p2-- != 0)
            res = (res * x) % mod
        return res
    }
}
