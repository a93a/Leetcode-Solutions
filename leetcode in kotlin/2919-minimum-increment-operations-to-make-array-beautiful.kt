class Solution {
    fun minIncrementOperations(nums: IntArray, k: Int): Long {
        var dp = ArrayDeque(listOf(0L, 0L, 0L))
        for (n in nums) {
            dp.addLast((dp.min() ?: 0L) + maxOf(k - n, 0))
            dp.removeFirst()
        }

        return dp.min() ?: 0L
    }
}
