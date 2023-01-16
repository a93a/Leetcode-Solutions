class Solution {
    fun rob(nums: IntArray): Int {
        var beforeLatest = 0; var latest = 0
        for(i in nums.indices){
            var temp = maxOf(beforeLatest+nums[i], latest)
            beforeLatest = latest
            latest = temp
        }
        return latest
    }
}
