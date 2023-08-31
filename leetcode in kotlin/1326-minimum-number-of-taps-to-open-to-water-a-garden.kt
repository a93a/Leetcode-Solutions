class Solution {
    fun minTaps(n: Int, ranges: IntArray): Int {
        val maxJump = IntArray (n + 1) { it }
        for (i in 0..n) {
            maxJump[maxOf(i - ranges[i], 0)] = i + ranges[i]
        }

        var cur = 0
        var next = 0
        var res = 0
        for (i in 0 until n) {
            if (i > cur) return -1

            next = maxOf(next, maxJump[i])
            if (i == cur) {
                cur = next
                res++
            }
        }

        return if (n > cur) -1 else res
    }
}
