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
    fun searchBST(root: TreeNode?, value: Int): TreeNode? {
        root?: return null
        
        if (root.value == value) return root
        else if(root.value < value) return searchBST(root.right, value)
        else return searchBST(root.left, value)
    }

    val TreeNode.value get()= this.`val`
}
