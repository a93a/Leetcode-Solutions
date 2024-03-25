class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        var res = 0
        for (n in nums) {
            if (n < k) res++
        }
        return res
    }
}
