class Solution {
    fun minIncrements(n: Int, cost: IntArray): Int {
        val last = n / 2 - 1

        var res = 0
        for (i in last downTo 0) {
            var abs = cost[2 * i + 1] - cost[2 * i + 2]
            if (abs < 0) abs *= -1
            cost[i] += maxOf(cost[2 * i + 1], cost[2 * i + 2])
            res += abs
        }

        return res
    }
}
