class Solution {
    fun sumDistance(nums: IntArray, s: String, d: Int): Int {
        val mod = 1000000007

        /*
         * Ignore direction changes, since we don't need to track robots, and if a robot x and
         * a robot y meet, and change directions we can look at it as if the two robots continued
         * on the same path/direction without changing direction. Keep long array to avoid Integer overflow
         */
        val afterMove = LongArray (nums.size).apply {
            for (i in 0 until nums.size) {
                if (s[i] == 'L') this[i] = (nums[i] - d).toLong()
                else this[i] = (nums[i] + d).toLong()
            }
        }
        
        // sort the robot positions in order to calculate the sum
        // of the distances of all robots in one sweep below
        afterMove.sort()

        /*
         * To avoid comparing all pairs of (i, j) and calculate in O(n^2),
         * we use a prefix sum to calculate this in O(n) + sorting of O(nlogn)
         */
        var res = 0L
        var prefix = 0L
        for (i in 1 until afterMove.size) {
            prefix += i * (afterMove[i] - afterMove[i - 1])
            res = (res + prefix) % mod
        }

        return res.toInt()
    }
}
