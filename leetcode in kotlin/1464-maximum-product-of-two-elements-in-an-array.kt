class Solution {
    fun maxProduct(nums: IntArray): Int {
        var max = -1
        var max2 = -1 
        for ((i, n) in nums.withIndex()) {
            if (n > max)
                max = n.also { max2 = max }
            else
                max2 = maxOf(max2, n)
        }
        return (max - 1) * (max2 - 1)
    }
}
