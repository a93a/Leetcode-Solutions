class Solution {
    fun maximumOr(nums: IntArray, k: Int): Long {
        var suffix = IntArray(nums.size).apply {
            for (i in nums.lastIndex - 1 downTo 0)
                this[i] = this[i + 1] or nums[i + 1]
        }

        var prefix = 0L
        var max = 0L
        for (i in 0..nums.lastIndex) {
            val num = nums[i].toLong()
            max = maxOf(
                max,
                prefix or (num shl k) or suffix[i].toLong()
            )
            prefix = prefix or num
        }

        return max
    }
}
