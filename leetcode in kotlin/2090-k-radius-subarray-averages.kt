class Solution {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        var res = IntArray (nums.size) { -1 }
        var sum = 0L
        val window = k * 2 + 1
        
        for (i in nums.indices) {
            sum += nums[i]
            if (i + 1 >= window) {
                if (i >= window) sum -= nums[i - window]
                res[i - window / 2] = (sum / window).toInt()
            }
        }

        return res
    }
}
