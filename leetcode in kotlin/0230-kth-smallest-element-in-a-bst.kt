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
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var n = 0
        val stack = Stack<TreeNode>()
        var current = root
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            n++
            if(n == k){
                return current.`val`
            }
            current = current.right
        }
        return -1
    }
}
