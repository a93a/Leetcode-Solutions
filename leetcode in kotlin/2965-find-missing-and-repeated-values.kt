class Solution {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val n = grid.size.toLong() * grid.size
        var sum = 0
        var sqrSum = 0L

        grid.forEach { row ->
            row.forEach { num ->
                sum += num
                sqrSum += num * num
            }
        }

        var eq1 = sum - n * (n + 1) / 2
        var eq2 = sqrSum - n * (n + 1) * (2 * n + 1) / 6
        return intArrayOf(
            ((eq2 / eq1 + eq1) / 2).toInt(),
            ((eq2 / eq1 - eq1) / 2).toInt()
        )
    }
}
