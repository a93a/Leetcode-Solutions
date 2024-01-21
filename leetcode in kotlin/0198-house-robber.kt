// DP Time O(n) and Space O(1)
class Solution {
    fun rob(nums: IntArray): Int {
        var dp3 = 0
        var dp2 = 0
        var dp1 = 0

        for (i in nums.indices) {
            dp1 = maxOf(
                nums[i] + dp3,
                dp2
            )
            dp3 = dp2
            dp2 = dp1
        }

        return dp1
    }
}

// DP Time O(n) and Space O(n)
class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray (n)
        dp[0] = nums[0]

        for (i in 1 until n) {
            dp[i] = maxOf(
                nums[i] + if (i > 1) dp[i - 2] else 0,
                dp[i - 1]
            )
        }

        return dp[n - 1]
    }
}

// Recursion + memoization Time O(n) and Space O(n)
class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        val dp = IntArray (n) { -1 }

        fun dfs(i: Int): Int {
            if (i >= n) return 0
            if (dp[i] != -1) return dp[i]

            dp[i] = maxOf(
                nums[i] + dfs(i + 2),
                dfs(i + 1)
            )

            return dp[i]
        }

        return dfs(0)
    }
}
