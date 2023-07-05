class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var max = 0
        var prev = 0
        var cur = 0

        for (n in nums) {
            if (n == 0) {
                prev = cur
                cur = 0
            } else {
                cur++
                max = maxOf(max, prev + cur)
            }
        }

        return if (max == nums.size) max - 1 else max
    }
}
