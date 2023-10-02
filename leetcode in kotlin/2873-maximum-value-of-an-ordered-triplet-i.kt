class Solution {
    fun maximumTripletValue(nums: IntArray): Long {
        val n = nums.size
        var max = Long.MIN_VALUE

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                for (k in j + 1 until n) {
                    var cur = (nums[i] - nums[j]).toLong() * nums[k]
                    max = maxOf(max, cur)
                }
            }
        }

        return if (max < 0L) 0L else max
    }
}
