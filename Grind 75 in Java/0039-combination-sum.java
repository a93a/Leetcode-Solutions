class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(target, 0, 0, new ArrayList<Integer>(), res, candidates);
        return res;
    }

    private void dfs(int t, int sum, int i, List<Integer> tmp, List<List<Integer>> res, int[] cnd) {
        if (sum > t) return;
        if (sum == t) {
            res.add(List.copyOf(tmp));
            return;
        }

        for (int j = i; j < cnd.length; j++) {
            int n = cnd[j];
            tmp.addLast(n);
            dfs(t, sum + n, j, tmp, res, cnd);
            tmp.removeLast();
        }
    }
}
