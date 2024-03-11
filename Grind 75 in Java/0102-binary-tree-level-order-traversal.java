class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();

        if (root == null) return res;

        q.addLast(root);
        while(!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.removeFirst();
                level.add(cur.val);

                if (cur.left != null)
                    q.addLast(cur.left);
                if (cur.right != null)
                    q.addLast(cur.right);
            }

            res.add(level);
        }

        return res;
    }
}
