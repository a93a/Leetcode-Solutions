class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val resList = mutableListOf<List<Int>>()
        nums.sort()     
        for(i in nums.indices){
            if(i>0 && nums[i]==nums[i-1])
               continue
            var left = i+1; var right = nums.size-1
            while(left<right){
                val sum = nums[i] + nums[left] + nums[right]
                if(sum > 0)
                    right--
                else if(sum < 0)
                    left++
                else{
                    resList.add(listOf(nums[i],nums[left],nums[right]))
                    left++
                    while(nums[left]==nums[left-1] && left < right)
                        left++
                }
            }
        }
        return resList
    }
}
