class Solution {
    fun bstToGst(root: TreeNode?): TreeNode? {
        var curSum = 0

        fun dfs(node: TreeNode?) {
            node?: return

            dfs(node.right)
            val temp = node.`val`
            node.`val` += curSum

            curSum += temp
            dfs(node.left)
        }

        dfs(root)
        return root
    }
}
