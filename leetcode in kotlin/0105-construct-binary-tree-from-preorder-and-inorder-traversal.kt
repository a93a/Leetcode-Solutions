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
//without using subarrays, seems to be faster and uses less memory
class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {   
        return build(preorder, inorder, 0, preorder.size-1, 0, inorder.size-1)
    }
    private fun build(
        preorder: IntArray, 
        inorder: IntArray, 
        preStart: Int, 
        preEnd: Int, 
        inStart: Int, 
        inEnd: Int
    ): TreeNode?{
        if(preStart > preEnd || inStart > inEnd)
            return null
        val root = TreeNode(preorder[preStart])
        val parentIndex = inorder.indexOf(preorder[preStart])
        root.left = build(preorder, inorder, preStart+1, preStart+(parentIndex-inStart),inStart, parentIndex-1)
        root.right = build(preorder, inorder, preStart+(parentIndex-inStart)+1, preEnd, parentIndex+1 , inEnd)
        return root
    }
}

//using subarrays
class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {   
        if(preorder.size == 0 || inorder.size == 0)
            return null
        val root = TreeNode(preorder[0])
        val parentIndex = inorder.indexOf(preorder[0])
        root.left = buildTree(preorder.copyOfRange(1,parentIndex+1),inorder.copyOfRange(0,parentIndex))
        root.right = buildTree(preorder.copyOfRange(parentIndex+1,preorder.size),inorder.copyOfRange(parentIndex+1, inorder.size))
        return root
    }
}
