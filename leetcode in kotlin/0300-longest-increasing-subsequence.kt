// O(n^2)
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) {1}

        for (i in nums.size-1 downTo 0) {
            for (j in i + 1 until nums.size) {
                if (nums[i] < nums[j]) {
                    dp[i] = maxOf(dp[i], 1 + dp[j])
                }
            }
        }

        return dp.max()!!
    }
}

// O(nlogn)
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val piles = mutableListOf<Int> ()

        for (num in nums) {
            var l = 0
            var r = piles.lastIndex
            var res = -1
            while (l <= r) {
                val m = l + (r - l) / 2
                if (piles[m] >= num){
                    res = m
                    r = m - 1
                } else {
                    l = m + 1
                }
            }
            
            if (res == -1) piles.add(num)
            else piles[res] = num
        }

        return piles.size
    }
}
