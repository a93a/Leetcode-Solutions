class Solution {
    fun maximumHappinessSum(h: IntArray, k: Int): Long {
        h.sortDescending()
        var sum = 0L
        for (i in 0 until k)
            sum += maxOf(0, h[i] - i)
        return sum
    }
}
