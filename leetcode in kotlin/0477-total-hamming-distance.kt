// O(n^2) brute force
class Solution {
    fun totalHammingDistance(nums: IntArray): Int {
        var res = 0
        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
                res += (nums[i] xor nums[j]).countOneBits()
            }
        }
        return res
    }
}
