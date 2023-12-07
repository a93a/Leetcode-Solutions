class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
    var res = IntArray (nums.size)
    nums.foldIndexed (1) { i, acc, v ->
        res[i] = acc
        acc * v
    }

    var suffix = 1
    for (i in nums.lastIndex downTo 0) {
        res[i] *= suffix
        suffix *= nums[i]
    }

    return res
    }
}
