class Solution {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var res = 0L
        var left = -1
        var lastMin = -1
        var lastMax = -1

        for(i in 0..nums.lastIndex) {
            if(nums[i] in minK..maxK) {
                if(nums[i] == minK) lastMin = i
                if(nums[i] == maxK) lastMax = i
                res += maxOf(0L, minOf(lastMin, lastMax).toLong() - left.toLong())
            }else{ 
                left = i
                lastMin = -1
                lastMax = -1
            }
        }

        return res
    }
}
