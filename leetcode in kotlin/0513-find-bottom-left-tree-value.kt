// BFS iterative
class Solution {
    fun findBottomLeftValue(root: TreeNode?): Int {
        var cur = root
        
        with (LinkedList<TreeNode?>()) {
            addLast(root)
            
            while (isNotEmpty()) {
                cur = removeFirst()
                cur?.right?.let { addLast(it) }
                cur?.left?.let { addLast(it) }
            }
        }
        
        return cur?.`val` ?: 0
    }
}

// DFS recursive
class Solution {
    fun findBottomLeftValue(root: TreeNode?): Int {
        var resLevel = -1
        var res = -1

        fun dfs(root: TreeNode?, level: Int) {
            root?: return

            if (root.left == null && level > resLevel) {
                res = root.`val`
                resLevel = level
            }

            dfs(root.left, level + 1)
            dfs(root.right, level + 1) 
        }

        dfs(root, 1)
        return res
    }
}
