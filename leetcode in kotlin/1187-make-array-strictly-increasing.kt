class Solution {
    fun makeArrayIncreasing(a1: IntArray, a2: IntArray): Int {
        val n = a1.size
        val dp = HashMap<Pair<Int, Int>, Int>()

        a2.sort()

        fun binarySearch(x: Int): Int {
            var left = 0
            var right = a2.size
            while (left < right) {
                val mid = (left + right) / 2
                if (a2[mid] <= x)
                    left = mid + 1
                else
                    right = mid
            }
            return left
        }

        fun dfs(i: Int, prev: Int): Int {
            if (i == a1.size) return 0
            dp[i to prev]?.let { return it }

            dp[i to prev] = 2001
            if (a1[i] > prev) dp[i to prev] = dfs(i + 1, a1[i])

            val index = binarySearch(prev)
            if (index < a2.size) {
                dp[i to prev] = minOf(
                    dp[i to prev] ?: 2001,
                    1 + dfs(i + 1, a2[index])
                )
            }

            return dp[i to prev] ?: 2001
        }

        val res = dfs(0, -1)
        return if (res == 2001) -1 else res
    }
}
