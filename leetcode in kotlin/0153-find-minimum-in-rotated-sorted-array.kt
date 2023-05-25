class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex

        var res = nums[0]
        while (left <= right) {
            if (nums[left] < nums[right]){
                res = minOf(res, nums[left])
                break
            }
                
            val mid = left + (right - left) / 2 
            res = minOf(res, nums[mid])
            if (nums[mid] >= nums[left])
                left = mid + 1
            else
                right = mid - 1
        }

        return res
    }
}

/*
* Different "logic"
*/
class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex

        while (left < right) {
            val mid = left + (right - left) / 2 
            if (nums[mid] > nums[right])
                left = mid + 1
            else
                right = mid
        }

        return nums[left]
    }
}
