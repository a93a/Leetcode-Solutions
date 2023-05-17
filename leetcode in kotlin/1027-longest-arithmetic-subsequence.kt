class Solution {
    fun longestArithSeqLength(nums: IntArray): Int {
        val dp = Array(nums.size) { HashMap<Int, Int>() }

        var res = 2
        for (i in 0 until nums.size) {
            for (j in 0 until i) {
                val diff = nums[i] - nums[j]
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1)
                res = maxOf(
                    res, 
                    dp[i].getOrDefault(diff, 2)
                )
            }
        }

        return res
    }
}
