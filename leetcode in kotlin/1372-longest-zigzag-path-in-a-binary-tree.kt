/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun longestZigZag(root: TreeNode?): Int {
        root?: return 0

        var maxLen = 0

        fun dfs(root: TreeNode?, toLeft: Boolean, steps: Int) {
            root?: return

            maxLen = maxOf(maxLen, steps)
 
            if (toLeft) {
                dfs(root.left, false, steps + 1)
                dfs(root.right, true, 1)
            } else {
                dfs(root.left, false, 1)
                dfs(root.right, true, steps + 1)
            }
        }

        dfs(root, false, 0)
        dfs(root, true, 0)
        
        return maxLen
    }
}
