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

//iterative version, labeled as "Very-Hard" problem on AlgoExpert
class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val res = ArrayList<Int>()
        val stack = Stack<TreeNode>()
                
        var node = root
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node)
                node = node.left
            }
            node = stack.pop()
            res.add(node.`val`)
            node = node.right
        }
    
        return res
    }
}

//recursion version, "easy"
class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val res = ArrayList<Int>()
        
        fun inOrder(node: TreeNode?) {
            node?: return
            inOrder(node.left)
            res.add(node.`val`)
            inOrder(node.right)
        }
        
        inOrder(root)
        return res
    }
}
