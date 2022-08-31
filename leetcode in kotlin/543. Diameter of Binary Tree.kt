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
    var max = -1
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return max
    }
    fun dfs(root: TreeNode?): Int {
        if(root == null) return 0
        var left = 0; var right = 0
        if(root?.left != null)
            left = dfs(root.left)
        if(root?.right != null)
            right = dfs(root.right)
        max = maxOf(max, left+right)
        return maxOf(left, right) + 1
    }
}
