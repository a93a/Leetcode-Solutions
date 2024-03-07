class Solution {
    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n == cur) {
                count++;
            } else if (count == 0) {
                count = 1;
                cur = n;
            } else {
                count--;
            }
        }

        return cur;
    }
}
