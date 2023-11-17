// O(n^2) brute force
// Get all pairs, and calculate difference in 1 bits by xor operation
class Solution {
    fun totalHammingDistance(nums: IntArray): Int {
        var res = 0
        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
                res += (nums[i] xor nums[j]).countOneBits()
            }
        }
        return res
    }
}

// O(n)
// For each bit position in a 32 bit Integer
// Count the total of num in nums that has that bit set to 1,
// And count the difference between those bits set with k * (n - k),
// where n == nums.size and k == total of num with bit set to 1
class Solution {
    fun totalHammingDistance(nums: IntArray): Int {
        var res = 0
        for (i in 0 until 32) {
            var count = 0
            for (num in nums) {
                count += (num shr i) and 1
            }
            res += count * (nums.size - count)
        }
        return res
    }
}
