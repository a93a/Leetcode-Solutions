// Same time complexity as below but with 2 passes a bit more "readability"
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

// ...or in one pass!
class Solution {
    fun maxFrequencyElements(nums: IntArray): Int {
        val freq = IntArray (101)
        var max = -1
        var res = 0
        
        for (n in nums) {
            freq[n]++
            if (freq[n] == max) {
                res += max
            } else if (freq[n] > max) {
                max = freq[n]
                res = max
            }
        }

        return res
    }
}
