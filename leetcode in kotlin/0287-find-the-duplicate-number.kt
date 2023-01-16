class Solution {
    // see the problem as a linked-list and use floyd-hare algorithm
    fun findDuplicate(nums: IntArray): Int {
        //first, find the intersection
        var slow = nums[0]
        var fast = nums[nums[0]]
        while(slow != fast){
            slow = nums[slow]
            fast = nums[nums[fast]]
        }
        //second, start a new slow pointer at start and the original slowpointer at intersection 
        var found = 0
        while(slow != found){
            slow = nums[slow];
            found = nums[found];
        }
        return found
    }
}
