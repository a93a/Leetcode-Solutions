// Optimized using Kadane's algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, curMax);
        }

        return maxSoFar;
    }
}

// DP non-optimized
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = Arrays.copyOf(nums, nums.length);
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
