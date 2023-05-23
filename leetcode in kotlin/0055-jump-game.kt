/*
* O(n) greedy
*/
class Solution {
    fun canJump(nums: IntArray): Boolean {
        var end = nums.lastIndex

        for (i in end - 1 downTo 0) {
            if (i + nums[i] >= end)
                end = i
        }

        return end == 0
    }
}

/*
* O(n^2) DP + memoization
*/
class Solution {
    fun canJump(nums: IntArray): Boolean {
        val deadEnd = BooleanArray(nums.size)

        fun canJump(i: Int): Boolean {
            if (i == nums.lastIndex)
                return true
            if (nums[i] == 0 || deadEnd[i] == true)
                return false

            for (jump in 1..nums[i]) {
                if (i + jump <= nums.lastIndex && canJump(i + jump)) {
                    return true
                }
            }

            deadEnd[i] = true
            return false
        }
        
        return canJump(0)
    }
}
