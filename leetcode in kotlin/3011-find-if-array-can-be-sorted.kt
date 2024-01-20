class Solution {
    fun canSortArray(nums: IntArray): Boolean {
        val n = nums.size

        fun b(i: Int, j: Int) = nums[i].countOneBits() == nums[j].countOneBits()

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (j + 1 < n && nums[j] > nums[j + 1] && b(j, j + 1)) {
                    nums[j] = nums[j + 1].also { nums[j + 1] = nums[j] } 
                }
            }
        }

        for (i in 1 until n) {
            if (nums[i - 1] > nums[i])
                return false
        }
        return true
    }
}
