// O(nlogn) time and O(1) space
class Solution {
    fun missingInteger(nums: IntArray): Int {
        var sum = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] != nums[i - 1] + 1) break
            sum += nums[i]
        }

        nums.sort()
        for (n in nums) {
            if (n == sum) sum++
        }

        return sum
    }
}

// Or O(n) time and O(n) space
class Solution {
    fun missingInteger(nums: IntArray): Int {
        var sum = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] != nums[i - 1] + 1) break
            sum += nums[i]
        }

        var numSet = nums.toSet()
        for (next in sum until sum + 50) {
            if (next !in numSet)
                return next
        }

        return sum
    }
}
