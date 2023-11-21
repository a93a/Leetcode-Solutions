class Solution {
    fun countNicePairs(nums: IntArray): Int {
        var mod = 1_000_000_000 + 7
        val count = HashMap<Int, Int>()

        var res = 0
        nums.forEach { x ->
            val y = x - x.rev()
            res += count[y] ?: 0
            res %= mod
            count[y] = (count[y] ?: 0) + 1
        }

        return res
    }

    fun Int.rev(): Int {
        var x = this
        var rev = 0
        while (x != 0) {
            rev *= 10
            rev += x % 10
            x /= 10
        }
        return rev
    }
}
