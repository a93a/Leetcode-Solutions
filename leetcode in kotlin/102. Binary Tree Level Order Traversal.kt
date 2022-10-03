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
    fun levelOrder(root: TreeNode?): List<List<Int>> {   
        val res: MutableList<MutableList<Int>> = mutableListOf()
        if(root == null)
            return res  
        val q = ArrayDeque<TreeNode>()
        q.add(root)   
        while(!q.isEmpty()){
            val levelValues: MutableList<Int> = mutableListOf()
            val count = q.size
            repeat(count){
                val curr = q.poll()
                levelValues.add(curr.`val`)
                if(curr.left != null)
                    q.add(curr.left)
                if(curr.right != null)
                    q.add(curr.right)
            }
            res.add(levelValues)
        }
        return res
    }
}
