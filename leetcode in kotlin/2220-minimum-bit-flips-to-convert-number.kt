class Solution {
    fun minBitFlips(start: Int, goal: Int): Int {
        var toFlip = start xor goal
        var res = 0

        while (toFlip > 0) {
            res += (toFlip and 1)
            toFlip = toFlip shr 1
        }

        return res
    }
}
