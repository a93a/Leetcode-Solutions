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
    var max = Integer.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        if(root == null)
            return -1
        max = root.`val`
        dfs(root)
        return max
    }
    private fun dfs(root: TreeNode?): Int {
        if(root == null)
            return 0
        val leftMax = maxOf(0, dfs(root.left))
        val rightMax = maxOf(0, dfs(root.right))
        max = maxOf(max, root.`val`+leftMax+rightMax)
        return root.`val` + maxOf(leftMax, rightMax)
    }
}
