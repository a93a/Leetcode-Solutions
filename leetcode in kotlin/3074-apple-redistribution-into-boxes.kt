class Solution {
    fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
        var sum = apple.sum() ?: 1
        capacity.sortDescending()
        var used = 0
        for (box in capacity) {
            if (sum == 0) break
            sum = maxOf(sum - box, 0)
            used++
        }
        return used
    }
}
