//DFS
class Solution {
    fun minDepth(root: TreeNode?): Int {
        root?: return 0
        var left = if (root.left == null) 100001 else minDepth(root.left)
        var right = if (root.right == null) 100001 else minDepth(root.right)
        return 1 + if (left + right == 200002) 0 else minOf(left, right)
    }
}

//BFS
class Solution {
    fun minDepth(root: TreeNode?): Int {
        root?: return 0

        return with (LinkedList<TreeNode?>()) {
            var res = 0
            addLast(root)
            while (isNotEmpty()) {
                res++
                repeat (size) {
                    val cur = removeFirst()!!
                    if (cur.left == null && cur.right == null)
                        return@with res
                    cur.left?.let { addLast(it) }
                    cur.right?.let { addLast(it) }
                }
            }
            res
        }
    }
}
