class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {      
        val res = intArrayOf(-1, -1)
        val map = HashMap<Int, Int>()
        
        for (i in nums.indices) {
            if (map.containsKey(nums[i])) {
                res[0] = i
                res[1] = map[nums[i]]!!
                break
            } else {
                map[target - nums[i]] = i
            }
        }

        return res
    }
}
