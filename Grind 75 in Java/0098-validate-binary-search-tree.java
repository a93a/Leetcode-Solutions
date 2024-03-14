class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean dfs(TreeNode cur, long max, long min) {
        if (cur == null) return true;
        if (cur.val >= max || cur.val <= min) return false;
        return dfs(cur.left, cur.val, min) && dfs(cur.right, max, cur.val);
    }
}
