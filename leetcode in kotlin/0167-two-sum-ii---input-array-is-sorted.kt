class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.lastIndex
        val res = intArrayOf(-1, -1)

        while (left < right) {
            val sum = numbers[left] + numbers[right]
            if (sum > target) {
                right--
            } else if (sum < target) {
                left++
            } else {
                res[0] = left + 1
                res[1] = right + 1
                break
            }
        }
        
        return res
    }
}
