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
    fun rightSideView(root: TreeNode?): List<Int> {
        val res: MutableList<Int> = mutableListOf()
        if(root == null)
            return res
        val q = ArrayDeque<TreeNode>()
        q.add(root)
        //level order, always pick the rightmost node for each level
        while(!q.isEmpty()){
            val size = q.size
            for(i in 1..size){
                val current = q.poll()
                if(current.left != null)
                    q.add(current.left)
                if(current.right != null)
                    q.add(current.right)
                if(i == size)
                    res.add(current.`val`)                    
            }
        }        
        return res
    }
}
