class Solution {
    int max = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        h(root);
        return max;
    }

    private int h(TreeNode r) {
        if (r == null) return 0;
        int left = h(r.left);
        int right = h(r.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
