class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(new ArrayList<Integer>(), res, nums, new boolean[nums.length]);
        return res;
    }

    private void dfs(List<Integer> tmp, List<List<Integer>> res, int[] nums, boolean[] taken) {
        if (tmp.size() == nums.length) {
            res.add(List.copyOf(tmp));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            int n = nums[j];

            if (taken[j]) continue;

            tmp.addLast(n);
            taken[j] = true;

            dfs(tmp, res, nums, taken);

            taken[j] = false;
            tmp.removeLast();
        }
    }
}
