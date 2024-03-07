class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }
}
