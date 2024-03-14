class Solution {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {

        fun count(x: Int): Int {
            if (x < 0) return 0

            var res = 0
            var l = 0
            var sum = 0
            for (r in 0 until nums.size) {
                sum += nums[r]

                while (sum > x)
                    sum -= nums[l++]

                res += (r - l + 1)
            }

            return res
        }

        return count(goal) - count(goal - 1)
    }
}
