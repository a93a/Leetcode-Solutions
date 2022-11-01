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


// Another way to do solve this is to use strinbuilder and create an inorder array of root tree and subroot tree
// Then use any of the string matching algorithms to see if subroot exists in root
// Could use KMP(Longest suffix prefix), Trie, Rabin-karp (String hashing), Aho-Corasick (Trie), etc

// DFS solution
// The easy solution
class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if(subRoot == null)
            return true
        if(root == null)
            return false
        if(root.`val` == subRoot.`val`)
            if(isSameTree(root, subRoot))
                return true
        return(isSubtree(root.left,  subRoot) || isSubtree(root.right, subRoot))
    }
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if(p == null && q == null)
            return true
        if(p == null || q == null)
            return false
        if(p.`val` != q.`val`)
            return false
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}
