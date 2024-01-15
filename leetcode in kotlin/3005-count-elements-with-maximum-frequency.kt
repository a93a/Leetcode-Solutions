class Solution {
    fun maxFrequencyElements(nums: IntArray): Int {
        val freq = IntArray (101)
        var max = -1
        for (n in nums) {
            freq[n]++
            max = maxOf(max, freq[n])
        }

        var res = 0
        for (n in freq)
            res += if (n == max) max else 0

        return res
    }
}
