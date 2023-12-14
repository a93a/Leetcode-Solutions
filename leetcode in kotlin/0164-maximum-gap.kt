class Solution {
    fun maximumGap(nums: IntArray): Int {
        val n = nums.size
        val max = nums.max()!!
        val min = nums.min()!!
        val diff = max - min

        if (nums.size < 2 || diff == 0)
            return 0

        val maxes = IntArray (n) { -1 }
        val mins = IntArray (n) { Integer.MAX_VALUE }
        for (num in nums) {
            val i = Math.ceil((num.toDouble() - min) / diff * (n - 1)).toInt()
            maxes[i] = maxOf(maxes[i], num)
            mins[i] = minOf(mins[i], num)
        }

        var prevMax = -1
        var res = 0
        for (i in 0 until n) {
            if (prevMax != -1 && mins[i] != Integer.MAX_VALUE)
                res = maxOf(res, mins[i] - prevMax)
            if (maxes[i] != -1)
                prevMax = maxes[i]
        }

        return res
    }
}
