class Solution {
    fun findMaxLength(nums: IntArray): Int {
        var one = 0
        var zero = 0
        var res = 0
        val diffs = HashMap<Int, Int> ()
        diffs[0] = -1

        for ((i, n) in nums.withIndex()) {
            if (n == 0) zero++
            else one++

            val diff = one - zero
            if (diff in diffs)
                res = maxOf(res, i - (diffs[diff] ?: 0))
            else
                diffs[diff] = i 

        }

        return res
    }
}
