class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++) {
            if(hm.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = hm.get(target - nums[i]);
                break;
            } else {
                hm.put(nums[i], i);
            }
        }

        return res;
    }
}