class Solution {
    fun findKOr(nums: IntArray, k: Int): Int {
        var res = 0
        for (i in 0 until 32) {
            var bitCount = 0
            for (n in nums) {
                bitCount += (n shr i) and 1
            }
            if (bitCount >= k)
                res += Math.pow(2.toDouble(), i.toDouble()).toInt()
        }
        return res
    }
}

// Small optimization, instead of using Math.pow(), we can use bit manipulation.
// Since we are only working with powers of 2, we can set each bit that fits our condition
// with OR
class Solution {
    fun findKOr(nums: IntArray, k: Int): Int {
        var res = 0
        for (i in 0 until 32) {
            var bitCount = 0
            for (n in nums) {
                bitCount += (n shr i) and 1
            }
            if (bitCount >= k)
                res += (1 shl i)
        }
        return res
    }
}
