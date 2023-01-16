/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null)
            return null
        if (p.`val` < root.`val` && q.`val` < root.`val`)
            return lowestCommonAncestor(root.left, p, q)
        else if(p.`val` > root.`val` && q.`val` > root.`val`)
            return lowestCommonAncestor(root.right, p, q)
        else //if root is LCS of Q and P, meaning that P and Q are on different sides of the tree
            return root
    }
}
