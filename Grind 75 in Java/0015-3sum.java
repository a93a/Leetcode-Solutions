class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
            hm.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    
                int find = 0 - (nums[i] + nums[j]);
                if (hm.containsKey(find) && hm.get(find) > j)
                    res.add(List.of(nums[i], nums[j], find));
            }
        }

        return res;
    }
}
