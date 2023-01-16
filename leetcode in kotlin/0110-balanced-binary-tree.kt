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
    fun isBalanced(root: TreeNode?): Boolean {
        if(root == null) return true
        return Math.abs(height(root.left) - height(root.right)) <= 1 
            && isBalanced(root.left) 
            && isBalanced(root.right)
    }
    fun height(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + maxOf(height(root.left), height(root.right))
    }
}
