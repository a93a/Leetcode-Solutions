class Solution {
    fun minPairSum(nums: IntArray): Int {
        nums.sort()
        val n = nums.size
        var res = -1
        for (i in 0 until n) {
            res = maxOf(res, nums[i] + nums[n - 1 - i])
        }
        return res
    }
}

// or use Kotlin idomatic functions
class Solution {
    fun minPairSum(nums: IntArray) = nums.sorted()
        .zip(nums.sortedDescending())
        .map { it.first + it.second }
        .max()
}
