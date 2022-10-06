class Solution {
    fun sortColors(nums: IntArray): Unit {
        var low = 0
        var high = nums.size-1
        var pointer = 0
        while(pointer <= high){
            if(nums[pointer] == 0){
                swap(low,pointer,nums)
                low++
                pointer++
            }
            else if (nums[pointer] == 2){
                 swap(high,pointer,nums)
                high--
            }else{ //nums[pointer] == 1
                pointer++
            }
        }
    }
    private fun swap(i: Int, j: Int, nums: IntArray){
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}
