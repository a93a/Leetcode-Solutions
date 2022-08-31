class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {      
        val result = IntArray(2)
    val map: MutableMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        if (map.containsKey(nums[i])) {
            result[0] = i
            result[1] = map[nums[i]]!!
            break
        } else {
            map[target - nums[i]] = i
        }
    }
    return result
    }
}
