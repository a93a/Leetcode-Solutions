class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        fun rob2(from: Int, to: Int): Int {
            var max1 = 0
            var max2 = 0
            for(i in from..to){
                val temp = maxOf(max1, max2 + nums[i])
                max2 = max1
                max1 = temp
            }
            return max1
        }
        
        return maxOf(rob2(0, nums.lastIndex - 1), rob2(1, nums.lastIndex))
    }
}
