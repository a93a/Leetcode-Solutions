class Solution {
    fun findSubarrays(nums: IntArray): Boolean {
        val hs = HashSet<Int>()
        for(i in 0 until nums.size-1) {//skip the last index, because its included in prev and next is out of bounds
            val sum = nums[i] + nums[i+1]
            if(sum !in hs)
                hs.add(sum)
            else
                return true
        }
        return false
    }
}
