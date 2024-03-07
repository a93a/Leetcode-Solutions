class Solution {
    public boolean isBalanced(TreeNode r) {
        if (r == null) return true;

        return Math.abs(height(r.left) - height(r.right)) <= 1 
            && isBalanced(r.left)
            && isBalanced(r.right);
    }

    private int height(TreeNode r) {
        if (r == null) return 0;
        return 1 + Math.max(height(r.left), height(r.right));
    }
}
