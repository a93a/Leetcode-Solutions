class Solution {
    fun minimumReplacement(nums: IntArray): Long {
        var res = 0L
        var last = nums[nums.lastIndex]

        for (i in nums.lastIndex - 1 downTo 0) {
            var steps = (nums[i] - 1) / last
            res += steps
            last = nums[i] / (steps + 1)
        }

        return res
    }
}
