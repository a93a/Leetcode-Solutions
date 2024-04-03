class Solution {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        val freq = IntArray (32)

        fun doOr(n: Int, s: Int): Int {
            for (i in 0 until 32) {
                if (n and (1 shl i) > 0) freq[i]++
            }
            return n or s
        }

        fun undoOr(n: Int, s: Int): Int {
            var s = s
            for (i in 0 until 32) {
                if (n and (1 shl i) > 0) {
                    freq[i]--
                    if (freq[i] == 0) s = s xor (1 shl i)
                }
            }
            return s
        }
        
        var l = 0
        var sum = 0
        var res = Int.MAX_VALUE
        for (r in nums.indices) {
            sum = doOr(nums[r], sum)
            while (sum >= k && l <= r) {
                res = minOf(res, r - l + 1)
                sum = undoOr(nums[l++], sum)
            }
        }

        return if (res != Int.MAX_VALUE) res else -1
    }
}
