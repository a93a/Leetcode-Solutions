class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        var i = 0
        while (i < n) {
            val j = nums[i] - 1
            if (j in (0 until n) && nums[i] != nums[j]) {
                nums[i] = nums[j].also { nums[j] = nums[i] }
            } else {
                i++
            }
        }

        for (i in nums.indices) {
            if (nums[i] != i + 1) return i + 1
        }

        return n + 1
    }
}
