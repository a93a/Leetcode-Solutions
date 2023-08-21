class Solution {
    fun countPairs(_nums: List<Int>, target: Int): Int {
        var res = 0
        val nums = _nums.sorted()
        
        var i = 0
        while (i < nums.size) {
            var j = i + 1
            while (j < nums.size && nums[i] + nums[j] < target) {
                res++
                j++
            }
            i++
        }
        
        return res
    }
}
