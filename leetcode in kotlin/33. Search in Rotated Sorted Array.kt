class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0; var r = nums.size-1     
        while(l <= r){
            val m = (l + r)/2
             if(target == nums[m])
                return m
            // right portion of sorted array
            if(nums[l] <= nums[m]){
                if(target > nums[m] || target < nums[l])
                    l = m + 1
                else // (target > nums[m] && target > nums[l])
                   r = m - 1
            }else{ //left sorted portion of array
                if(target < nums[m] || target > nums[r])
                    r = m - 1
                else //(target < nums[m] && target > nums[r])
                    l = m + 1                  
            }
        }
        return -1
    }
}
