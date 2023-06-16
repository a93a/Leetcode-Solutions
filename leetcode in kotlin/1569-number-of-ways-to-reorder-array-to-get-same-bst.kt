class Solution {
    fun numOfWays(nums: IntArray): Int {
        val mod = 1000000007
        val n = nums.size
        val dp = Array (n) { LongArray (n) }

        fun dfs(nums: ArrayList<Int>) : Long {
            if (nums.size < 3) return 1L

            val left = ArrayList<Int>()
            val right = ArrayList<Int>()
            for (i in 1 until nums.size) {
                if (nums[i] < nums[0])
                    left.add(nums[i])
                else
                    right.add(nums[i])
            }
            val leftWays = 0L + dfs(left) % mod
            val rightWays = 0L + dfs(right) % mod

            return (((leftWays * rightWays) % mod) * dp[nums.lastIndex][left.size]) % mod
        }

        for (i in 0 until n) {
            dp[i][0] = 1L
            dp[i][i] = 1L
        }

        for (i in 2 until n) {
            for (j in 1 until i) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod
            }
        }

        return ((dfs(nums.toCollection(ArrayList())) - 1) % mod).toInt()
    }
}
