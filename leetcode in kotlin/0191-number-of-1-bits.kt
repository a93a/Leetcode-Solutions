class Solution {
    fun hammingWeight(n: Int): Int {
        var count = 0
        var x = n
        while (x != 0) {
            count += (x and 1)
            x = x ushr 1
        }
        return count
    }
}
