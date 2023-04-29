class Solution {
    fun countOperationsToEmptyArray(nums: IntArray): Long {
        val sortNums = Array(nums.size){IntArray(2)}

        for (i in nums.indices) {
            sortNums[i][0] = nums[i]
            sortNums[i][1] = i
        }
        sortNums.sortBy{ it[0] }

        var res = 0L + nums.size
        for (i in 1..sortNums.lastIndex) {
            if (sortNums[i - 1][1] > sortNums[i][1])
                res += nums.size - i
        }
        
        return res
    }
}
