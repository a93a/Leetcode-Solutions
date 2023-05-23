/*
* O(n) BFS
*/
class Solution {
    fun jump(nums: IntArray): Int {
        var min = 0
        var left = 0
        var right = 0

        while (right < nums.lastIndex) {
            var maxJumpPos = 0
            for (i in left..right)
                maxJumpPos = maxOf(maxJumpPos, i + nums[i])
            left = right + 1
            right = maxJumpPos
            min++
        }

        return min
    }
}

/*
* O(N^2) DP + memoization
*/
class Solution {
    fun jump(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 10001 }

        fun jump(i: Int): Int {
            if (i == nums.lastIndex)
                return 0
            if (dp[i] != 10001)
                return dp[i]

            for (steps in 1..nums[i]) {
                if (i + steps <= nums.lastIndex) {
                    dp[i] = minOf(
                        dp[i],
                        1 + jump(i + steps)
                    )
                }
            }

            return dp[i]
        }
        
        return jump(0)
    }
}
