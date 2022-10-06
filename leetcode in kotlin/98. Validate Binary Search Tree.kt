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
    fun isValidBST(root: TreeNode?): Boolean {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE) //Long to handle Largest/smallest Int numbers from the test cases
    }
    private fun isValid(root: TreeNode?, minVal: Long, maxVal: Long): Boolean {
        if(root == null)
            return true
        if(root.`val` <= minVal || root.`val` >= maxVal)
            return false
        return isValid(root.left,minVal,root.`val`.toLong()) && 
            isValid(root.right,root.`val`.toLong(),maxVal)
    }
}
