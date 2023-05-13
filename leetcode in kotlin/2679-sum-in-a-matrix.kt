class Solution {
    fun matrixSum(nums: Array<IntArray>): Int {
        var res = 0
        
        while (true) {
            var iMax = -1
            
            for (i in 0 until nums.size) {
                var jMax = -1
                
                for (j in 0 until nums[0].size) {
                    jMax = maxOf(jMax, nums[i][j])
                }
                
                for (j in 0 until nums[0].size) {
                    if (nums[i][j] == jMax) {
                        nums[i][j] = -1
                        break
                    }
                }
                
                
                iMax = maxOf(iMax, jMax)
            }
            
            if (iMax == -1) break        
            res += iMax
            iMax = Integer.MIN_VALUE
        }
        
        return res
    }
}
