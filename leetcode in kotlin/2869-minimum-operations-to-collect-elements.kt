class Solution {
    fun minOperations(nums: List<Int>, k: Int): Int {
        var bitmask = 0L
        var op = 0
        var all = 0L

        repeat (k) {
            all = all shl 1
            all = all or 1
        }

        var i = nums.lastIndex
        while (bitmask and all != all && i >= 0) {
            bitmask = bitmask or (1L shl nums[i] - 1)
            i--
            op++
        }

        return op
    }
}
