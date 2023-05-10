class Solution {
    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        var subArr = HashMap<Int, Int>()

        var subArrSum = 0L
        var res = 0L
        for (i in 0..nums.lastIndex) {
            subArr[nums[i]] = subArr.getOrDefault(nums[i], 0) + 1
            subArrSum += nums[i]

            if (i >= k - 1) {
                if (subArr.size == k) res = maxOf(res, subArrSum)
                subArrSum -= nums[i - k + 1]

                val n = nums[i - k + 1]
                if (subArr[n] == 1) 
                    subArr.remove(n) 
                else 
                    subArr[n] = subArr[n]!! - 1
            }
        }

        return res
    }
}
