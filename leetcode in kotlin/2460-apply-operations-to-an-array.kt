class Solution {
    fun applyOperations(nums: IntArray): IntArray {
        for (i in 0..nums.lastIndex - 1) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2
                nums[i + 1] = 0
            }
        }

        for (i in 0..nums.lastIndex - 1) {
            if (nums[i] == 0) {
                var j = i
                while (j < nums.lastIndex && nums[j] == 0) j++
                nums.swap(i, j)
            }
        }

        return nums
    }

    fun IntArray.swap(i: Int, j: Int) {
        this[i] = this[j].also { this[j] = this[i] }
    }
}
