class Solution {
    fun semiOrderedPermutation(nums: IntArray): Int {
        var one = 0
        var n = 0
        for (i in nums.indices) {
            if (nums[i] == 1)
                one = i
            if (nums[i] == nums.size)
                n = i
        }
        var swaps = one + nums.lastIndex - n
        if (n < one) swaps--
        return swaps
    }
}
