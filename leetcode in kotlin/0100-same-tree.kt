// DFS recursive
class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        if (p.`val` != q.`val`) return false
        
        return isSameTree(p.left, q.left) 
            && isSameTree(p.right, q.right)
    }
}

// BFS iterative
class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        val stack = LinkedList<Pair<TreeNode?, TreeNode?>> ()
        stack.addLast(p to q)

        while (stack.isNotEmpty()) {
            val (p, q) = stack.removeLast()

            if (p == null && q == null) continue
            if (p == null || q == null) return false
            if (p.`val` != q.`val`) return false

            stack.addLast(p.left to q.left)
            stack.addLast(p.right to q.right)
        }

        return true
    }
}
