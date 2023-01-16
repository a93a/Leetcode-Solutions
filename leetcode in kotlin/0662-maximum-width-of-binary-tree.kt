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
    //time: O(n) and space(logN)
    fun widthOfBinaryTree(root: TreeNode?): Int {
        var width = 0
        val levelMap = HashMap<Int, Int>()
        
        fun dfs(node: TreeNode?, depth: Int, pos: Int, levelMap: HashMap<Int, Int>) {
            node?: return
            if(!levelMap.contains(depth)) //We do in order traversal of the tree, meaning we will reach the left most pos of each tree first
                levelMap[depth] = pos // so we save this for each level of tree
            width = maxOf(width, (pos - levelMap[depth]!! + 1)) // we will hit a max 
            dfs(node.left, depth+1, 2*pos, levelMap)
            dfs(node.right, depth+1, 2*pos+1, levelMap)
        }
              
        dfs(root, 0, 0, levelMap)
        return width
    }
    
}
